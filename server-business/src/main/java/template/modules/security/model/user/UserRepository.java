package template.modules.security.model.user;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import template.shared.user.attribbute.UserCode;

@Dao
@ConfigAutowireable
public interface UserRepository {

    @Select
    User findOneByUserCode(UserCode userCode);

    @Insert
    Result<User> insert(User user);
    
}
