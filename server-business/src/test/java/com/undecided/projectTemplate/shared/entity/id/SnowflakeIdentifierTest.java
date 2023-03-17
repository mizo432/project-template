package com.undecided.projectTemplate.shared.entity.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SnowflakeIdentifierTest {

    /**
     * Method under test: {@link SnowflakeIdentifier#asString()}
     */
    @Test
    void testAsString() {
        // Arrange, Act and Assert
        assertNull(SnowflakeIdentifier.empty().asString());
    }

    /**
     * Method under test: {@link SnowflakeIdentifier#reconstruct(String)}
     */
    @Test
    void testReconstruct() {
        // Arrange, Act and Assert
        assertEquals(42L, SnowflakeIdentifier.reconstruct(42L).getValue());
    }

    /**
     * Method under test: {@link SnowflakeIdentifier#UildIdentifier()}
     */
    @Test
    void testConstructor() {
        // Arrange, Act and Assert
        assertNull((new SnowflakeIdentifier<>()).getValue());
    }
}

