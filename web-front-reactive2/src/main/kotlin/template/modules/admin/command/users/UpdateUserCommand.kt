package template.modules.admin.command.users

import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service
import template.modules.admin.domain.users.User
import template.modules.admin.domain.users.UserRepository

@Service
class UpdateUserCommand(private val repo: UserRepository) {
    suspend fun execute(id: Long, user: User): User? {
        val existingUser = findById(id)
        return if (existingUser != null) repo.save(user).awaitSingleOrNull() else null
    }

    private suspend fun findById(id: Long) =
        repo.findById(id).awaitSingleOrNull()
}