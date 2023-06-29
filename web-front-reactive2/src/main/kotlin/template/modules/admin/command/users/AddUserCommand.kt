package template.modules.admin.command.users

import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service
import template.modules.admin.domain.users.User
import template.modules.admin.domain.users.UserRepository

@Service
class AddUserCommand(private val repo: UserRepository) {
    suspend fun execute(user: User) = repo.save(user).awaitSingleOrNull();

}