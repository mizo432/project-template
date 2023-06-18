package template.shared.value;

import com.undecided.primitive.string.Strings2;

/**
 * 文字列を保持する値オブジェクトの基底クラス
 */
public abstract class AbstractStringValue extends AbstractValue<String> implements StringValue {

    /**
     * 保持している値
     */
    private final String value;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    protected AbstractStringValue(String value) {
        this.value = value;
    }

    /**
     * コンストラクター
     */
    protected AbstractStringValue() {
        value = null;
    }

    public String getValue() {
        return value;
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
