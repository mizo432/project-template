package com.undecided.projectTemplate.modules.resource.domain.story.efort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EffortTest {

    /**
     * Method under test: {@link Effort#of(Integer)}
     */
    @Test
    void testOf() {
        // Arrange, Act and Assert
        assertEquals(42, Effort.of(42).getValue().intValue());
    }

    /**
     * Method under test: {@link Effort#reconstruct(Integer)}
     */
    @Test
    void testReconstruct() {
        // Arrange, Act and Assert
        assertEquals(42, Effort.reconstruct(42).getValue().intValue());
    }
}

