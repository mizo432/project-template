package com.undecided.projectTemplate.shared.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.primitive.string.Strings2;

public abstract class AbstractStringValue extends AbstractValue<String> implements StringValue {

    private final String value;

    protected AbstractStringValue(String value) {
        this.value = value;
    }

    protected AbstractStringValue() {
        value = null;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (Strings2.isEmpty(getValue())) {
            return null;
        }
        return value;
    }

    @Override
    public String asString() {
        if (Strings2.isEmpty(value)) {
            return null;
        }

        return getValue();

    }

    @JsonIgnore
    public boolean isEmpty() {
        return Strings2.isEmpty(value);

    }
}
