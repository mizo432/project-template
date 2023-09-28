package template.shared.value;

import com.undecided.primitive.object.Objects2;

import java.time.YearMonth;

/**
 * 年月の値オブジェクトの基底クラス
 */
public abstract class AbstractYearMonthValue extends AbstractValue<YearMonth> implements YearMonthValue {

    /**
     * 値
     */
    protected final YearMonth value;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    protected AbstractYearMonthValue(final YearMonth value) {
        this.value = value;

    }

    /**
     * コンストラクター
     */
    protected AbstractYearMonthValue() {
        value = null;

    }

    @Override
    public YearMonth getValue() {
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
