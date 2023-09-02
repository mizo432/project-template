package template.modules.security.appl.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import template.shared.entity.id.SnowflakeId;

/**
 * ユーザー.
 */
@Getter
@Entity(immutable = true)
@Table(schema = "security", name = "user")
@AllArgsConstructor
@ToString
public class User {

    @Id
    private final SnowflakeId userId;

    private final UserAttribute userAttribute;

    public boolean isEmpty() {
        return userId.isEmpty() && userAttribute.isEmpty();
    }
}
