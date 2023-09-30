package com.undecided.primitive.array;

import com.undecided.test.size.SmallTest;
import org.junit.jupiter.api.Assertions;

class Arrays2Test {

    /**
     * Method under test: {@link Arrays2#isEmpty(Object[])}
     */
    @SmallTest
    void testIsEmpty() {
        Assertions.assertFalse(Arrays2.isEmpty(new Object[]{"Reference Array"}));
        Assertions.assertTrue(Arrays2.isEmpty(new Object[]{}));
    }

    /**
     * Method under test: {@link Arrays2#isEmpty(Object[])}
     */
    @SmallTest
    void testIsEmpty2() {
        Assertions.assertThrows(NullPointerException.class, () -> Arrays2.isEmpty(null));

    }

    /**
     * Method under test: {@link Arrays2#isEmptySilently(Object[])}
     */
    @SmallTest
    void testIsEmptySilently() {
        Assertions.assertFalse(Arrays2.isEmptySilently(new Object[]{"Reference Array"}));
        Assertions.assertTrue(Arrays2.isEmptySilently(new Object[]{}));
    }
}

