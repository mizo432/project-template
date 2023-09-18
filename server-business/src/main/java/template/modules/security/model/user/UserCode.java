package template.modules.security.model.user;

import lombok.NoArgsConstructor;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

/**
 * ユーザーコード
 */
@NoArgsConstructor
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class UserCode extends AbstractStringValue {
    /**
     * コンストラクター
     *
     * @param value 値
     */
    UserCode(final String value) {
        super(value);
    }

    /**
     * ファクトリーメソッド
     *
     * @param value 値
     * @return ユーザーコード
     */
    public static UserCode of(final String value) {
        return new UserCode(value);
    }

    /**
     * 再生成メソッド
     *
     * @param value 値
     * @return ユーザーコード
     */
    public static UserCode reconstruct(final String value) {
        return new UserCode(value);
    }
}
