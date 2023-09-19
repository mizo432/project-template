package template.shared.value;

import com.undecided.primitive.string.Strings2;
import lombok.Getter;

/**
 * 文字列を保持する値オブジェクトの基底クラス
 */
@Getter
public abstract class AbstractCodeValue extends AbstractValue<String> implements CodeValue {

    /**
     * 保持している値
     */
    private final String value;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    protected AbstractCodeValue(final String value) {
        this.value = value;

    }

    /**
     * コンストラクター
     */
    protected AbstractCodeValue() {
        value = null;
        
    }

    @Override
    public String toString() {
        if (Strings2.isEmpty(getValue())) {
            return null;
        }
        return value;
    }

    @Override
    public String asString() {
        if (Strings2.isEmpty(value)) {
            return null;
        }

        return getValue();

    }

    @Override
    public boolean isEmpty() {
        return Strings2.isEmpty(value);

    }
}
