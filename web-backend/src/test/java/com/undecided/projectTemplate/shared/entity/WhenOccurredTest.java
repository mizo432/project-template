package com.undecided.projectTemplate.shared.entity;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WhenOccurredTest {

    /**
     * Method under test: {@link WhenOccurred#reconstruct(LocalDateTime)}
     */
    @Nested
    class reconstruct {

        @Test
        void testReconstruct() {
            // Arrange
            int year = 1;
            int month = 1;
            int dayOfMonth = 1;
            int hour = 1;
            int minute = 1;
            LocalDateTime ofResult = LocalDateTime.of(year, month, dayOfMonth, hour, minute);

            // Act
            WhenOccurred actualReconstructResult = WhenOccurred.reconstruct(ofResult);
            LocalDateTime actualValue = actualReconstructResult.getValue();

            // Assert
            assertSame(ofResult, actualValue);
        }

    }
}

