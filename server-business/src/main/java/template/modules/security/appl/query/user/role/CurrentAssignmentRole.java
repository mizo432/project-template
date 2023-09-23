package template.modules.security.appl.query.user.role;

import com.undecided.primitive.set.Sets2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import template.modules.security.model.role.RoleCode;
import template.shared.value.AbstractListValue;
import template.shared.value.AbstractStringValue;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@ToString
@Entity(immutable = true)
public class CurrentAssignmentRole extends AbstractStringValue {
    @Column(name = "role_code")
    private RoleCode roleCode;

    public static class AssignmentRoles extends AbstractListValue<CurrentAssignmentRole> {

        public AssignmentRoles(final List<CurrentAssignmentRole> value) {
            super(value);
        }

        public static AssignmentRoles reconstruct(final List<CurrentAssignmentRole> value) {
            return new AssignmentRoles(value);
        }

        @Override
        public String asString() {
            return toString();
        }

        public Set<String> roleStringSet() {
            Set<String> result = Sets2.newHashSet();
            for (final CurrentAssignmentRole currentAssignmentRole : getValue()) {
                result.add(currentAssignmentRole.getRoleCode().asString());

            }
            return result;
        }
    }
}
