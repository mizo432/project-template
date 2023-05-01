package com.undecided.projectTemplate.shared.value;

import com.undecided.primitive.list.Lists2;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

import static com.undecided.primitive.list.Lists2.newArrayList;

public abstract class AbstractListValue<E> implements ListValue<E> {
    protected final List<E> value = newArrayList();

    protected AbstractListValue() {

    }

    protected AbstractListValue(@NotNull Collection<E> value) {
        this.value.addAll(value);

    }

    @Override
    public List<E> getValue() {
        return Lists2.unmodifiableList(value);
    }

    @Override
    public boolean isEmpty() {
        return value.isEmpty();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
