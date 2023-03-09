package com.undecided.projectTemplate.shared.value;

import com.undecided.primitive.string.Strings2;

public interface StringValue<T> extends Value<String> {

    String getValue();

    String asString();

    default boolean isEmpty() {
        return Strings2.isEmpty(getValue());

    }

}
