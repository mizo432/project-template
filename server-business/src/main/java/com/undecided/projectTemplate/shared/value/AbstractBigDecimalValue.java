package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;
import java.math.BigDecimal;

public abstract class AbstractBigDecimalValue extends AbstractValue<BigDecimal> implements
    BigDecimalValue {

    private final BigDecimal value;

    protected AbstractBigDecimalValue(BigDecimal value) {
        this.value = value;
    }

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

    @JsonIgnore
    public boolean isEmpty() {
        return Objects2.isNull(value);

    }
}
