package template.modules.admin.command.users

import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service
import template.modules.admin.domain.users.UserRepository

@Service
class DeleteUserCommand(private val repo: UserRepository) {
    suspend fun execute(id: Long): Boolean {
        val existingUser = findById(id)
        return if (existingUser != null) {
            repo.deleteById(id).awaitSingleOrNull()
            true
        } else
            false
    }

    private suspend fun findById(id: Long) =
        repo.findById(id).awaitSingleOrNull()
}