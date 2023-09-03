package template.modules.security.model.user.assignmentRole;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@Dao
@ConfigAutowireable
public interface AssignmentRoleRepository {
    @Insert
    Result<AssignmentRole> insert(AssignmentRole assignmentRole);

}
