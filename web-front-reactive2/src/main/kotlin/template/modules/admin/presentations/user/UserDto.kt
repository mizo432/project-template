package template.modules.admin.presentations.user

import template.modules.admin.domain.users.User

data class UserDto(
    val name: String,
    val login: String,
    val email: String,
    val avatar: String? = null
)

fun UserDto.toModel(withId: Long? = null) = User(withId, this.name, this.login, this.email, this.avatar)
