package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;
import java.time.LocalDateTime;

public interface DateTimeValue extends SingleValue<LocalDateTime> {

    @JsonIgnore
    default boolean isEmpty() {
        return Objects2.isNull(getValue());

    }
}
