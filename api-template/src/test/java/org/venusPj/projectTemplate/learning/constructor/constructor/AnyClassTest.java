package org.venusPj.projectTemplate.learning.constructor.constructor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnyClassTest {

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AnyClass#AnyClass(String)}
     *   <li>{@link AnyClass#getValue()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("42", (new AnyClass("42")).getValue());
    }
}

