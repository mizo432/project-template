package template.modules.security.appl.model.user.settingPassword;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import template.shared.entity.id.SnowflakeId;

@Dao
@ConfigAutowireable
public interface CurrentSettingPasswordRepository {
    @Select
    CurrentSettingPassword findOneById(SnowflakeId userId);

}
