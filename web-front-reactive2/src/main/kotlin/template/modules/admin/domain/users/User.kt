package template.modules.admin.domain.users

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("tutorial")
class User(
    @Id
    val id: Long? = null,
    val name: String,
    val login: String,
    val email: String,
    val avatar: String? = null

)
