package template.modules.security.appl.query.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import template.modules.security.model.user.User;
import template.modules.security.model.user.settingpassword.EncodedPassword;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.MultiValue;

/**
 * 認証ユーザー
 */
@AllArgsConstructor
@Getter
@ToString(exclude = {"encodedPassword"})
@EqualsAndHashCode
public class AuthUser implements MultiValue<AuthUser> {

    private final User user;
    private final EncodedPassword encodedPassword;

    /**
     * 再生成
     *
     * @param user            ユーザ
     * @param encodedPassword エンコード済みパスワード
     * @return 認証ユーザ
     */
    public static AuthUser reconstruct(final User user, final EncodedPassword encodedPassword) {
        return new AuthUser(user, encodedPassword);
    }

    /**
     * 表法が空かを返却する
     *
     * @return 空の場合true
     */
    @Override
    public boolean isEmpty() {
        return user.isEmpty() && encodedPassword.isEmpty();
    }

    public SnowflakeId userId() {
        return user.getUserId();
    }
}
