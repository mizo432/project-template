package com.undecided.projectTemplate.shared.entity.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SnowflakeIdentifierTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SnowflakeIdentifierTest.class);

    /**
     * Method under test: {@link SnowflakeIdentifier#asString()}
     */
    @Test
    void testToString() {
        // Arrange, Act and Assert
        LOGGER.info(SnowflakeIdentifier.empty().toString());
    }

    @Test
    void testToString2() {
        // Arrange, Act and Assert
        for (int i = 0; i < 5000; i++) {
            LOGGER.info(SnowflakeIdentifier.newInstance().toString());

        }
    }

    /**
     * Method under test: {@link SnowflakeIdentifier#asString()}
     */
    @Test
    void testAsString() {
        // Arrange, Act and Assert
        assertNull(SnowflakeIdentifier.empty().asString());
    }

    /**
     * Method under test: {@link SnowflakeIdentifier#reconstruct(Long)}
     */
    @Test
    void testReconstruct() {
        // Arrange, Act and Assert
        assertEquals(42L, SnowflakeIdentifier.reconstruct(42L).getValue());
    }

    /**
     * Method under test: {@link SnowflakeIdentifier#SnowflakeIdentifier()}
     */
    @Test
    void testConstructor() {
        // Arrange, Act and Assert
        assertNull((new SnowflakeIdentifier<>()).getValue());
    }
}

