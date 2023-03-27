package com.undecided.projectTemplate.shared.entity.id;

import com.undecided.primitive.set.Sets2;
import com.undecided.projectTemplate.shared.value.SetValue;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public class Identifiers<E> implements
        SetValue<SnowflakeIdentifier<E>>, Serializable {

    private final Set<SnowflakeIdentifier<E>> value = Sets2.newHashSet();

    Identifiers(Collection<E> value) {
        value.addAll(value);
    }

    public Identifiers() {

    }

    @Override
    public Set<SnowflakeIdentifier<E>> getValue() {
        return value;
    }

    public static <E> Identifiers<E> of(Collection<E> value) {
        return new Identifiers<>(value);

    }

    public boolean isEmpty() {
        return value.isEmpty();

    }

}
