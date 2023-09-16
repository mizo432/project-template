package template.modules.security.model.user.assignmentRole;

import com.undecided.primitive.list.Lists2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import template.modules.security.model.role.Role;
import template.modules.security.model.role.RoleCode;
import template.modules.security.model.user.User;
import template.modules.security.model.user.UserCode;
import template.shared.entity.WhenOccurred;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.AbstractListValue;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Getter
@Entity(immutable = true)
@Table(schema = "security", name = "assignment_role")
@AllArgsConstructor
@ToString
public class AssignmentRole {
    @Id
    @Column(name = "assignment_role_id")
    private final SnowflakeId assignmentRoleId;

    @Column(name = "user_id")
    private final SnowflakeId userId;
    @Column(name = "role_id")
    private final SnowflakeId roleId;
    @Column(name = "when_occurred")
    private final WhenOccurred whenOccurred;

    public static AssignmentRole create(SnowflakeId userId, SnowflakeId roleId) {
        return new AssignmentRole(SnowflakeId.newInstance(), userId, roleId, WhenOccurred.current());

    }

    public static class AssignmentsRole extends AbstractListValue<AssignmentRole> {

        public AssignmentsRole(final Collection<AssignmentRole> value) {
            super(value);
        }

        public static AssignmentsRole initialize(User.Users users, Role.Roles roles) {
            List<AssignmentRole> assignmentRoleList = Lists2.newArrayList();
            final Optional<User> adminOptionalUser = users.findByUserCode(UserCode.of("admin"));
            User adminUser = adminOptionalUser.orElseThrow(RuntimeException::new);
            final Optional<User> standerdOptionalUser = users.findByUserCode(UserCode.of("user"));
            User standerdUser = standerdOptionalUser.orElseThrow(RuntimeException::new);
            final Optional<Role> adminOptionalRole = roles.findByRoleCode(RoleCode.of("ADMIN"));
            Role adminRole = adminOptionalRole.orElseThrow(RuntimeException::new);
            final Optional<Role> standerdOptionalRole = roles.findByRoleCode(RoleCode.of("USER"));
            Role standerdRole = standerdOptionalRole.orElseThrow(RuntimeException::new);

            assignmentRoleList.add(AssignmentRole.create(adminUser.getUserId(), adminRole.getRoleId()));
            assignmentRoleList.add(AssignmentRole.create(adminUser.getUserId(), standerdRole.getRoleId()));
            assignmentRoleList.add(AssignmentRole.create(standerdUser.getUserId(), standerdRole.getRoleId()));
            return of(assignmentRoleList);
        }

        private static AssignmentsRole of(final Collection<AssignmentRole> value) {
            return new AssignmentsRole(value);

        }

        @Override
        public String asString() {
            return toString();
        }

        public void forEach(final Consumer<AssignmentRole> consumer) {
            value.forEach(consumer);
        }
    }
}
