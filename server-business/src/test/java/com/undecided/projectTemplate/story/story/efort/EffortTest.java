package com.undecided.projectTemplate.story.story.efort;

import com.undecided.projectTemplate.story.domain.story.efort.Effort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

