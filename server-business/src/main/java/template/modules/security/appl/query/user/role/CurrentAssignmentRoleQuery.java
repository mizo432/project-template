package template.modules.security.appl.query.user.role;

import template.modules.security.appl.query.user.role.CurrentAssignmentRole.AssignmentRoles;
import template.shared.entity.id.SnowflakeId;

public interface CurrentAssignmentRoleQuery {

    AssignmentRoles selectByUserId(SnowflakeId userId);

}
