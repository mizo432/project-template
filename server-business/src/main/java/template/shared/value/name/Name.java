package template.shared.value.name;

import com.undecided.primitive.string.Strings2;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

import java.io.Serial;
import java.io.Serializable;

/**
 * 名称
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class Name extends AbstractStringValue implements Serializable {
    /**
     * nullオブジェクト
     */
    public static final Name EMPTY_VALUE = new Name();
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    /* default */Name(String value) {
        super(value);
    }

    /**
     * コンストラクター
     */
    public Name() {
        super();
    }

    /**
     * ファクトリーメソッド
     *
     * @param value 値
     * @return 名称
     */
    public static Name of(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY_VALUE;
        }

        return new Name(value);

    }

    /**
     * 再生成メソッド
     *
     * @param value 値
     * @return 名称
     */
    public static Name reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY_VALUE;
        }
        return new Name(value);

    }

}
