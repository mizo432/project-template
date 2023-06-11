package com.undecided.projectTemplate.shared.entity.id;

import com.undecided.primitive.set.Sets2;
import com.undecided.projectTemplate.shared.value.SetValue;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public class Identifiers implements
        SetValue<SnowflakeId>, Serializable {

    private final Set<SnowflakeId> value = Sets2.newHashSet();

    Identifiers(Collection<SnowflakeId> value) {
        this.value.addAll(value);
    }

    public Identifiers() {

    }

    public static Identifiers of(Collection<SnowflakeId> value) {
        return new Identifiers(value);

    }

    @Override
    public Set<SnowflakeId> getValue() {
        return value;
    }

    public boolean isEmpty() {
        return value.isEmpty();

    }

}
