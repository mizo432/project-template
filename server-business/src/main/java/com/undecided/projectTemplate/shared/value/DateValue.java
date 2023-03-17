package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;
import java.time.LocalDate;

public interface DateValue<T> extends SingleValue<LocalDate> {

    @JsonIgnore
    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }
}
