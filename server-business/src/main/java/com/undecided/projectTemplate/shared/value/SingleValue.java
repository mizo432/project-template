package com.undecided.projectTemplate.shared.value;

public interface SingleValue<T> extends Value {

    T getValue();

    String asString();

    boolean isEmpty();

}
