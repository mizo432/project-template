package template.modules.security.appl.model.user;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import template.shared.user.attribbute.UserCode;

@Dao
@ConfigAutowireable
public interface UserRepository {

    @Select
    User findOneByUserCode(UserCode userCode);
}
