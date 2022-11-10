package org.venusPj.projectTemplate.shared.primitive.array;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Arrays2Test {

    /**
     * Method under test: {@link Arrays2#isEmpty(Object[])}
     */
    @Test
    void testIsEmpty() {
        assertFalse(Arrays2.isEmpty(new Object[]{"Reference Array"}));
        assertTrue(Arrays2.isEmpty(new Object[]{}));
    }

    /**
     * Method under test: {@link Arrays2#isEmpty(Object[])}
     */
    @Test
    void testIsEmpty2() {
        assertThrows(NullPointerException.class, () -> Arrays2.isEmpty(null));

    }

    /**
     * Method under test: {@link Arrays2#isEmptySilently(Object[])}
     */
    @Test
    void testIsEmptySilently() {
        assertFalse(Arrays2.isEmptySilently(new Object[]{"Reference Array"}));
        assertTrue(Arrays2.isEmptySilently(new Object[]{}));
    }
}

