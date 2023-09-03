package template.modules.security.model.role;

import com.undecided.primitive.list.Lists2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.AbstractListValue;
import template.shared.value.name.Name;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * ユーザー.
 */
@Getter
@Entity(immutable = true)
@Table(schema = "security", name = "role")
@AllArgsConstructor
@ToString
public class Role {
    @Id
    @Column(name = "role_id")
    private final SnowflakeId roleId;

    @Column(name = "role_code")
    private final RoleCode roleCode;

    @Column(name = "role_name")
    private final Name roleName;

    private static Role create(final String roleCode, final String roleName) {
        return create(RoleCode.of(roleCode), Name.of(roleName));

    }

    private static Role create(final RoleCode roleCode, final Name roleName) {
        return new Role(SnowflakeId.newInstance(), roleCode, roleName);

    }

    public boolean isEmpty() {
        return roleId.isEmpty() && roleCode.isEmpty() && roleName.isEmpty();

    }

    public static class Roles extends AbstractListValue<Role> {

        public Roles(final Collection<Role> value) {
            super(value);
        }

        public static Roles of(final Collection<Role> value) {
            return new Roles(value);
        }

        public static Roles initialRoles() {
            Role adminRole = Role.create("ADMIN", "システム管理者");
            Role standerduserRole = Role.create("USER", "一般ユーザー");

            return Roles.of(Lists2.newArrayList(adminRole, standerduserRole));
        }

        @Override
        public String asString() {
            return toString();

        }

        public void forEach(final Consumer<Role> consumer) {
            value.forEach(consumer);
        }

        public Optional<Role> findByRoleCode(final RoleCode roleCode) {
            return value
                    .stream()
                    .filter(role -> role
                            .getRoleCode()
                            .equals(roleCode))
                    .findFirst();

        }
    }


}
