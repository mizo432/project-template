package org.venusPj.primitive.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.venusPj.primitive.array.Arrays2;

class Arrays2Test {

    /**
     * Method under test: {@link Arrays2#isEmpty(Object[])}
     */
    @Test
    void testIsEmpty() {
        Assertions.assertFalse(Arrays2.isEmpty(new Object[]{"Reference Array"}));
        Assertions.assertTrue(Arrays2.isEmpty(new Object[]{}));
    }

    /**
     * Method under test: {@link Arrays2#isEmpty(Object[])}
     */
    @Test
    void testIsEmpty2() {
        Assertions.assertThrows(NullPointerException.class, () -> Arrays2.isEmpty(null));

    }

    /**
     * Method under test: {@link Arrays2#isEmptySilently(Object[])}
     */
    @Test
    void testIsEmptySilently() {
        Assertions.assertFalse(Arrays2.isEmptySilently(new Object[]{"Reference Array"}));
        Assertions.assertTrue(Arrays2.isEmptySilently(new Object[]{}));
    }
}

