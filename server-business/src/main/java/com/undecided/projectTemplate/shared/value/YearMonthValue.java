package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;
import java.time.YearMonth;

public interface YearMonthValue<T> extends SingleValue<YearMonth> {

    @JsonIgnore
    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }

}
