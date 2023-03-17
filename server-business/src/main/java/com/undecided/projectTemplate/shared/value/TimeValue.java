package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;
import java.time.LocalTime;

public interface TimeValue<T> extends SingleValue<LocalTime> {

    @JsonIgnore
    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }
}
