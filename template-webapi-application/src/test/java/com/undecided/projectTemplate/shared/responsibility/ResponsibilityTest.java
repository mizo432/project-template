package com.undecided.projectTemplate.shared.responsibility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ResponsibilityTest {

    /**
     * Method under test: {@link Responsibility#of(String)}
     */
    @Test
    void testOf() {
        // Arrange
        String value = "42";

        // Act
        Responsibility actualOfResult = Responsibility.of(value);

        System.out.println(actualOfResult);

        // Assert
        String expectedValue = "42";
        String actualValue = actualOfResult.getValue();
        assertEquals(expectedValue, actualValue);
    }
}

