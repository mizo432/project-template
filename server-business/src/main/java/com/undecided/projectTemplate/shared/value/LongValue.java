package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;

public interface LongValue<T> extends SingleValue<Long> {


    String asString();

    @JsonIgnore
    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }

}
