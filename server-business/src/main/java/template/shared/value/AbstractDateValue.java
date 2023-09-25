package template.shared.value;

import com.undecided.primitive.object.Objects2;

import java.time.LocalDate;

/**
 * 日付の値オブジェクトの基底クラス
 */
public abstract class AbstractDateValue extends AbstractValue<LocalDate> implements
        DateValue {

    /**
     * 値
     */
    protected final LocalDate value;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    protected AbstractDateValue(final LocalDate value) {
        this.value = value;
    }

    /**
     * コンストラクター
     */
    protected AbstractDateValue() {
        value = null;
    }

    @Override
    public LocalDate getValue() {
        return value;
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
