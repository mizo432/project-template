package template.modules.security.model.role;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.List;

@Dao
@ConfigAutowireable
public interface RoleRepository {
    @Select
    List<Role> selectAll();

    @Insert
    Result<Role> insert(Role role);

}
