package com.undecided.projectTemplate.shared.entity.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class IdentifierTest {

    /**
     * Method under test: {@link Identifier#asString()}
     */
    @Test
    void testAsString() {
        // Arrange, Act and Assert
        assertNull(Identifier.empty().asString());
    }

    /**
     * Method under test: {@link Identifier#reconstruct(String)}
     */
    @Test
    void testReconstruct() {
        // Arrange, Act and Assert
        assertEquals("42", Identifier.reconstruct("42").getValue());
    }

    /**
     * Method under test: {@link Identifier#of(String)}
     */
    @Test
    void testOf() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> Identifier.of("42"));
        assertEquals("42runtimeExceptionSupplier",
            Identifier.of("42runtimeExceptionSupplier").getValue());
    }

    /**
     * Method under test: {@link Identifier#Identifier()}
     */
    @Test
    void testConstructor() {
        // Arrange, Act and Assert
        assertNull((new Identifier<>()).getValue());
    }
}

