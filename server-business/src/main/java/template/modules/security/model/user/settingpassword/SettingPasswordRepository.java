package template.modules.security.model.user.settingpassword;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@Dao
@ConfigAutowireable
public interface SettingPasswordRepository {

    /**
     * パスワード設定をインサートする
     *
     * @param settingPassword パスワード設定
     * @return 登録済みパスワード設定
     */
    @Insert
    Result<SettingPassword> insert(final SettingPassword settingPassword);

}
