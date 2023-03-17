package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;

public interface IntegerValue<T extends IntegerValue<T>> extends SingleValue<Integer> {

    @JsonIgnore
    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }
}
