package com.undecided.projectTemplate.shared.entity.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class IdentifierTest {

    /**
     * Method under test: {@link UildIdentifier#asString()}
     */
    @Test
    void testAsString() {
        // Arrange, Act and Assert
        assertNull(UildIdentifier.empty().asString());
    }

    /**
     * Method under test: {@link UildIdentifier#reconstruct(String)}
     */
    @Test
    void testReconstruct() {
        // Arrange, Act and Assert
        assertEquals("42", UildIdentifier.reconstruct("42").getValue());
    }

    /**
     * Method under test: {@link UildIdentifier#of(String)}
     */
    @Test
    void testOf() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> UildIdentifier.of("42"));
        assertEquals("42runtimeExceptionSupplier",
            UildIdentifier.of("42runtimeExceptionSupplier").getValue());
    }

    /**
     * Method under test: {@link UildIdentifier#UildIdentifier()}
     */
    @Test
    void testConstructor() {
        // Arrange, Act and Assert
        assertNull((new UildIdentifier<>()).getValue());
    }
}

