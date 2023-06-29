package template.modules.admin.presentations.user

import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import template.modules.admin.command.users.AddUserCommand
import template.modules.admin.command.users.DeleteUserCommand
import template.modules.admin.command.users.UpdateUserCommand
import template.modules.admin.query.users.UserFetcher

@Component
class UserHandler(
    private var addUserCommand: AddUserCommand,
    private var updateUserCommand: UpdateUserCommand,
    private var deleteUserCommand: DeleteUserCommand,
    private var userFetcher: UserFetcher
) {
    private val logger = LoggerFactory.getLogger(UserHandler::class.java)

    suspend fun findAll(request: ServerRequest): ServerResponse {
        val users = userFetcher.findAll()
        return ServerResponse.ok().json().bodyAndAwait(users)
    }

    suspend fun search(request: ServerRequest): ServerResponse {
        val criterias = request.queryParams()
        return when {
            criterias.isEmpty() -> ServerResponse.badRequest().json()
                .bodyValueAndAwait(ErrorMessage("Search must have query params"))

            criterias.contains("email") -> {
                val criteriaValue = criterias.getFirst("email")
                if (criteriaValue.isNullOrBlank()) {
                    ServerResponse.badRequest().json()
                        .bodyValueAndAwait(ErrorMessage("Incorrect search criteria value"))
                } else {
                    ServerResponse.ok().json().bodyAndAwait(userFetcher.findByEmail(criteriaValue))
                }
            }

            else -> ServerResponse.badRequest().json().bodyValueAndAwait(ErrorMessage("Incorrect search criteria"))
        }
    }

    suspend fun findUser(request: ServerRequest): ServerResponse {
        val id = request.pathVariable("id").toLongOrNull()
        return if (id == null) {
            ServerResponse.badRequest().json().bodyValueAndAwait(ErrorMessage("`id` must be numeric"))
        } else {
            val user = userFetcher.findById(id)
            if (user == null) ServerResponse.notFound().buildAndAwait()
            else ServerResponse.ok().json().bodyValueAndAwait(user)
        }
    }

    suspend fun addUser(request: ServerRequest): ServerResponse {
        val newUser = try {
            request.bodyToMono<UserDto>().awaitFirstOrNull()
        } catch (e: Exception) {
            logger.error("Decoding body error", e)
            null
        }
        return if (newUser == null) {
            ServerResponse.badRequest().json().bodyValueAndAwait(ErrorMessage("Invalid body"))
        } else {
            val user = addUserCommand.execute(newUser.toModel())
            if (user == null) ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).json()
                .bodyValueAndAwait(ErrorMessage("Internal error"))
            else ServerResponse.status(HttpStatus.CREATED).json().bodyValueAndAwait(user)
        }
    }

    suspend fun updateUser(request: ServerRequest): ServerResponse {
        val id = request.pathVariable("id").toLongOrNull()
        return if (id == null) {
            ServerResponse.badRequest().json().bodyValueAndAwait(ErrorMessage("`id` must be numeric"))
        } else {
            val updateUser = try {
                request.bodyToMono<UserDto>().awaitFirstOrNull()
            } catch (e: Exception) {
                logger.error("Decoding body error", e)
                null
            }
            if (updateUser == null) {
                ServerResponse.badRequest().json().bodyValueAndAwait(ErrorMessage("Invalid body"))
            } else {
                val user = updateUserCommand.execute(id, updateUser.toModel())
                if (user == null) ServerResponse.status(HttpStatus.NOT_FOUND).json()
                    .bodyValueAndAwait(ErrorMessage("Resource $id not found"))
                else ServerResponse.status(HttpStatus.OK).json().bodyValueAndAwait(user)
            }
        }
    }

    suspend fun deleteUser(request: ServerRequest): ServerResponse {
        val id = request.pathVariable("id").toLongOrNull()
        return if (id == null) {
            ServerResponse.badRequest().json().bodyValueAndAwait(ErrorMessage("`id` must be numeric"))
        } else {
            if (deleteUserCommand.execute(id)) ServerResponse.noContent().buildAndAwait()
            else ServerResponse.status(HttpStatus.NOT_FOUND).json()
                .bodyValueAndAwait(ErrorMessage("Resource $id not found"))
        }
    }
}