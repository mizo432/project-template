package com.undecided.projectTemplate.shared.entity.id;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SnowflakeIdTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SnowflakeIdTest.class);

    /**
     * Method under test: {@link SnowflakeId#asString()}
     */
    @Test
    void testToString() {
        // Arrange, Act and Assert
        LOGGER.info(SnowflakeId.empty().toString());
    }

    @Test
    void testToString2() {
        // Arrange, Act and Assert
        for (int i = 0; i < 5000; i++) {
            LOGGER.info(SnowflakeId.newInstance().toString());

        }
    }

    /**
     * Method under test: {@link SnowflakeId#asString()}
     */
    @Test
    void testAsString() {
        // Arrange, Act and Assert
        assertNull(SnowflakeId.empty().asString());
    }

    /**
     * Method under test: {@link SnowflakeId#reconstruct(Long)}
     */
    @Test
    void testReconstruct() {
        // Arrange, Act and Assert
        assertEquals(42L, SnowflakeId.reconstruct(42L).getValue());
    }

    /**
     * Method under test: {@link SnowflakeId#SnowflakeId()}
     */
    @Test
    void testConstructor() {
        // Arrange, Act and Assert
        assertNull((new SnowflakeId()).getValue());
    }
}

