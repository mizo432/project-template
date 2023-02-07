package com.undecided.primitive.object;

import java.util.Objects;

public class Objects2 {

    public static final Object[] EMPTY_ARRAY = new Object[0];

    public static boolean isNull(Object reference) {
        return reference == null;

    }

    public static boolean equal(Object o, Object o1) {
        return Objects.equals(o, o1);
    }

    public static boolean nonNull(Object o) {
        return o != null;
    }
}
