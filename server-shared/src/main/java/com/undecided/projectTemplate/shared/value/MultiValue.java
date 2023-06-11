package com.undecided.projectTemplate.shared.value;

public interface MultiValue<T extends MultiValue<T>> extends Value {

    boolean isEmpty();

}
