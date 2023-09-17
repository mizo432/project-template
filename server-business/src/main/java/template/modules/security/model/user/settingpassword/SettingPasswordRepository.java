package template.modules.security.model.user.settingpassword;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@Dao
@ConfigAutowireable
public interface SettingPasswordRepository {
    @Insert
    Result<SettingPassword> insert(SettingPassword settingPassword);

}
