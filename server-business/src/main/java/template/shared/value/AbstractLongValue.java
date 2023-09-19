package template.shared.value;

import com.undecided.primitive.object.Objects2;
import lombok.Getter;

/**
 * Long型を保持する値オブジェクトの基底クラス
 */
@Getter
public abstract class AbstractLongValue extends AbstractValue<Long> implements LongValue {

    /**
     * 保持している値
     */
    private final Long value;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    protected AbstractLongValue(final Long value) {
        this.value = value;

    }

    /**
     * コンストラクター
     */
    protected AbstractLongValue() {
        value = null;

    }

    @Override
    public String toString() {
        if (Objects2.isNull(value)) {
            return null;
        }
        return value.toString();
    }

    @Override
    public String asString() {
        if (Objects2.isNull(value)) {
            return null;
        }

        return value.toString();

    }

}
