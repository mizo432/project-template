package com.undecided.projectTemplate.shared.comparator;

import static com.undecided.primitive.object.Objects2.isNull;

import java.util.Comparator;

public class ComparableComparator<C extends Comparable<C>> implements Comparator<C> {

    private static final ComparableComparator<? extends Comparable<?>> INSTANCE = new ComparableComparator<>();

    @SuppressWarnings("unchecked")
    public static <C extends Comparable<C>> ComparableComparator<C> getInstance() {
        return (ComparableComparator<C>) INSTANCE;
    }

    @Override
    public int compare(C o1, C o2) {
        if (isNull(o1) && isNull(o2)) {
            return 0;
        }
        if (isNull(o1)) {
            return -1;
        }
        if (isNull(o2)) {
            return -2;
        }

        return o1.compareTo(o2);

    }
}
