package org.venusPj.projectTemplate.shared.precondition.array;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ArrayPreconditionsTest {

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[])}
     */
    @Test
    void testCheckNotEmpty() {
        ArrayPreconditions.checkNotEmpty(new Object[]{"Reference Array"});
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[])}
     */
    @Test
    void testCheckNotEmpty2() {
        assertThrows(IllegalArgumentException.class, () ->
            ArrayPreconditions.checkNotEmpty(null));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[])}
     */
    @Test
    void testCheckNotEmpty3() {
        assertThrows(IllegalArgumentException.class,
            () -> ArrayPreconditions.checkNotEmpty(new Object[]{}));
    }

}

