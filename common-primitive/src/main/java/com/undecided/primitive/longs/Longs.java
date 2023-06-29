package com.undecided.primitive.longs;

public class Longs {
    public static Long toLongOrNull(String value) {
        try {
            return Long.valueOf(value);

        } catch (RuntimeException re) {
            return null;
        }
    }

}
