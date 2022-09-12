package org.venusPj.projectTemplate.learning.constructor.factoryMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnyClassTest {

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AnyClass#createAnyClass(String)}
     *   <li>{@link AnyClass#getValue()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("42", (AnyClass.createAnyClass("42")).getValue());
    }
}

