package template.modules.security.model.user.settingpassword;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import template.shared.entity.id.SnowflakeId;

@Dao
@ConfigAutowireable
public interface CurrentSettingPasswordRepository {
    /**
     * ユーザーIDにより現在パスワードセッティングを検索する
     *
     * @param userId ユーザーID
     * @return 現在パスワードセッティング
     */
    @Select
    CurrentSettingPassword findOneByUserId(final SnowflakeId userId);

}
