package template.shared.value;

import com.undecided.primitive.object.Objects2;

import java.time.LocalTime;

/**
 * 時刻の値オブジェクトの基底クラス
 */
public abstract class AbstractTimeValue extends AbstractValue<LocalTime> implements
        TimeValue {

    /**
     * 値
     */
    protected final LocalTime value;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    protected AbstractTimeValue(final LocalTime value) {
        this.value = value;
    }

    /**
     * コンストラクター
     */
    protected AbstractTimeValue() {
        value = null;
    }

    @Override
    public LocalTime getValue() {
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
