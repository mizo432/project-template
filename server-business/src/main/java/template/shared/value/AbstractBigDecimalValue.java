package template.shared.value;

import com.undecided.primitive.object.Objects2;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * BigDecimal値の基底クラス
 */
@Getter
public abstract class AbstractBigDecimalValue extends AbstractValue<BigDecimal> implements
        BigDecimalValue {

    private final BigDecimal value;

    /**
     * コンストラクター
     *
     * @param value 値
     */
    protected AbstractBigDecimalValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * 引お数なしコンストラクター
     */
    protected AbstractBigDecimalValue() {
        value = null;
    }

    @Override
    public String toString() {
        if (Objects2.isNull(value)) {
            return null;
        }
        return value.toString();
    }

}
