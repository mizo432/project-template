package template.modules.security.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;


/**
 * ユーザーイニシャル
 */
@Getter
@NoArgsConstructor
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class UserInitial extends AbstractStringValue {

    /**
     * コンストラクター
     *
     * @param value 値
     */
    UserInitial(String value) {
        super(value);
    }

    /**
     * 再生成する
     *
     * @param value 値
     * @return メンバーイニシャル
     */
    public static UserInitial reconstruct(String value) {
        return new UserInitial(value);
    }

    /**
     * ファクトリーメソッド
     *
     * @param value 値
     * @return メンバーイニシャル
     */
    public static UserInitial of(String value) {
        return new UserInitial(value);

    }

}
