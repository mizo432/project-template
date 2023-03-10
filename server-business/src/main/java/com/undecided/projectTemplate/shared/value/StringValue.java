package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.string.Strings2;

public interface StringValue<T> extends Value<String> {

    String getValue();

    String asString();

    @JsonIgnore
    default boolean isEmpty() {
        return Strings2.isEmpty(getValue());

    }

}
