package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.string.Strings2;

public interface StringValue<T> extends SingleValue<String> {

    @JsonIgnore
    default boolean isEmpty() {
        return Strings2.isEmpty(getValue());

    }

}
