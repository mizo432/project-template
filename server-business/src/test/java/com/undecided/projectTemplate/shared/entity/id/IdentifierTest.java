package com.undecided.projectTemplate.shared.entity.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class IdentifierTest {

    /**
     * Method under test: {@link UlidIdentifier#asString()}
     */
    @Test
    void testAsString() {
        // Arrange, Act and Assert
        assertNull(UlidIdentifier.empty().asString());
    }

    /**
     * Method under test: {@link UlidIdentifier#reconstruct(String)}
     */
    @Test
    void testReconstruct() {
        // Arrange, Act and Assert
        assertEquals("42", UlidIdentifier.reconstruct("42").getValue());
    }

    /**
     * Method under test: {@link UlidIdentifier#of(String)}
     */
    @Test
    void testOf() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UlidIdentifier.of("42"));
        assertEquals("42runtimeExceptionSupplier",
            UlidIdentifier.of("42runtimeExceptionSupplier").getValue());
    }

    /**
     * Method under test: {@link UlidIdentifier#UlidIdentifier()}
     */
    @Test
    void testConstructor() {
        // Arrange, Act and Assert
        assertNull((new UlidIdentifier<>()).getValue());
    }
}

