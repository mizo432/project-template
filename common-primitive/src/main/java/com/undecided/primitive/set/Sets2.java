package com.undecided.primitive.set;

import java.util.Arrays;
import java.util.HashSet;

public class Sets2 {

    public static <I> HashSet<I> newHashSet() {
        return new HashSet<>();

    }

    @SafeVarargs
    public static <I> HashSet<I> newHashSet(I... values) {
        return new HashSet<>(Arrays.asList(values));

    }

}
