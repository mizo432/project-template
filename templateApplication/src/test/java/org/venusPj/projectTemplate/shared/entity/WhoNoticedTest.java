package org.venusPj.projectTemplate.shared.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WhoNoticedTest {

    /**
     * Method under test: {@link WhoNoticed#reconstruct(String)}
     */
    @Test
    void testReconstruct() {
        // Arrange
        String whoNoticed = "Who Noticed";

        // Act
        WhoNoticed actualReconstructResult = WhoNoticed.reconstruct(whoNoticed);
        String actualValue = actualReconstructResult.getValue();

        // Assert
        String expectedValue = "Who Noticed";
        assertEquals(expectedValue, actualValue);
    }
}

