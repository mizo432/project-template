package template.modules.security.model.role;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;
import template.shared.value.CodeValue;

/**
 * ロールコード
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class RoleCode extends AbstractStringValue implements CodeValue {
    /**
     * コンストラクター
     *
     * @param value 値
     */
    RoleCode(String value) {
        super(value);
    }

    /**
     * ファクトリーメソッド
     *
     * @param value 値
     * @return ロールコード
     */
    public static RoleCode reconstruct(String value) {
        return new RoleCode(value);

    }

    public static RoleCode of(final String value) {
        return new RoleCode(value);
    }
}

