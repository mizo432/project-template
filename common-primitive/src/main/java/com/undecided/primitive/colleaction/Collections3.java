package com.undecided.primitive.colleaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

public class Collections3 {

    public static <T> List<T> sort(Collection<T> collection, Comparator<T> comparator) {
        var list = copy(collection);
        list.sort(comparator);
        return list;

    }

    public static <T> List<T> copy(Collection<T> collection) {
        return new ArrayList<T>(collection);

    }

    public static <T> void addAllIf(@NotNull Collection<T> sourceCollection,
        @NotNull Collection<T> destCollection,
        Predicate<T> predicate) {
        destCollection.addAll(sourceCollection.stream().parallel().filter(predicate).toList());

    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection.isEmpty();

    }
}
