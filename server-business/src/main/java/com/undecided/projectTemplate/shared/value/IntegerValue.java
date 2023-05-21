package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;

/**
 * Integer値インターフェイス
 */
public interface IntegerValue extends SingleValue<Integer> {

    @JsonIgnore
    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }

}
