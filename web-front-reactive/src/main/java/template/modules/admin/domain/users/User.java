package template.modules.admin.domain.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("tutorial")
@Data
@AllArgsConstructor(staticName = "create")
public class User {
    @Id
    Long id;
    String name;
    String login;
    String email;
    String avatar;

}
