package com.undecided.projectTemplate.story.story.estimate.velocity;

import com.undecided.projectTemplate.modules.story.domain.model.estimate.velocity.DaysOfSprint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaysOfSprintTest {

    /**
     * Method under test: {@link DaysOfSprint#reconstruct(Integer)}
     */
    @Test
    void testReconstruct() {
        // Arrange
        int value = 42;

        // Act
        DaysOfSprint actualReconstructResult = DaysOfSprint.reconstruct(value);
        Integer actualValue = actualReconstructResult.getValue();

        // Assert
        int expectedIntValueResult = 42;
        int actualIntValueResult = actualValue.intValue();
        assertEquals(expectedIntValueResult, actualIntValueResult);
    }
}

