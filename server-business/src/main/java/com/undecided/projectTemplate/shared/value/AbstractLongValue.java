package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.object.Objects2;

public abstract class AbstractLongValue extends AbstractValue<Long> implements LongValue {

    private final Long value;

    protected AbstractLongValue(Long value) {
        this.value = value;

    }

    protected AbstractLongValue() {
        value = null;

    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (Objects2.isNull(value)) {
            return null;
        }
        return value.toString();
    }

    @Override
    public String asString() {
        if (Objects2.isNull(value)) {
            return null;
        }

        return value.toString();

    }

    @JsonIgnore
    public boolean isEmpty() {
        return Objects2.isNull(value);

    }

}
