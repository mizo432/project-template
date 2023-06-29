package template.modules.admin.query.users

import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service
import template.modules.admin.domain.users.UserRepository

@Service
class UserFetcher(private val repo: UserRepository) {
    suspend fun findAll() = repo.findAll().asFlow()
    suspend fun findById(id: Long) = repo.findById(id).awaitFirstOrNull()
    suspend fun findByEmail(email: String) = repo.findByEmail(email).asFlow()
}