package com.undecided.projectTemplate.shared.value;

import com.undecided.primitive.object.Objects2;
import java.math.BigDecimal;

public interface BigDecimalValue<T> extends SingleValue<BigDecimal> {

    default boolean isEmpty() {
        return Objects2.isNull(getValue());
    }
}
