package template.shared.type.description;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

import java.io.Serial;
import java.io.Serializable;

import static com.undecided.primitive.string.Strings2.emptyToNull;

/**
 * 詳細
 */
@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class Description extends AbstractStringValue implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final Description EMPTY_VALUE = new Description();

    /**
     * コンストラクター
     */
    private Description() {
        super();
    }

    /**
     * コンストラクター
     *
     * @param value 値
     */
    /* default */ Description(String value) {
        super(emptyToNull(value));
    }

    /**
     * 再生成
     *
     * @param value 値
     * @return 詳細
     */
    public static Description reconstruct(String value) {
        Description description = new Description(value);
        if (EMPTY_VALUE.equals(description)) {
            return EMPTY_VALUE;
        }
        return description;

    }

    /**
     * ファクトリー
     *
     * @param value 値
     * @return 詳細
     */
    public static Description of(String value) {
        return new Description(value);
    }

    /**
     * 空オブジェクトを取得する
     *
     * @return 詳細
     */
    public static Description empty() {
        return EMPTY_VALUE;
    }

}
