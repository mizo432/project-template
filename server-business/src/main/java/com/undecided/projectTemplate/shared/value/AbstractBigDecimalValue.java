package com.undecided.projectTemplate.shared.value;

import com.undecided.primitive.object.Objects2;

import java.math.BigDecimal;

/**
 * BigDecimal値の基底クラス
 */
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

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (Objects2.isNull(value)) {
            return null;
        }
        return value.toString();
    }

}
