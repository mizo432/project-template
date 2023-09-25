package template.modules.security.infra.query.user.role;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import template.modules.security.appl.query.user.role.CurrentAssignmentRole;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

@Dao
@ConfigAutowireable
public interface CurrentAssignmentRoleRepository {
    @Select
    List<CurrentAssignmentRole> selectByUserId(final SnowflakeId userId);
}
