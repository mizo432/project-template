package template.modules.security.infra.query.user.role;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import template.modules.security.appl.query.user.role.CurrentAssignmentRoleQuery;
import template.shared.entity.id.SnowflakeId;

import static template.modules.security.appl.query.user.role.CurrentAssignmentRole.AssignmentRoles;

@Service
@AllArgsConstructor
@Slf4j
public class RoleQueryImpl implements CurrentAssignmentRoleQuery {
    private final CurrentAssignmentRoleRepository currentAssignmentRoleRepository;

    @Override
    public AssignmentRoles selectByUserId(final SnowflakeId userId) {
        return AssignmentRoles.reconstruct(currentAssignmentRoleRepository.selectByUserId(userId));
    }
}
