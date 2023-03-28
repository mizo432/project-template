package com.undecided.projectTemplate.resource.domain.story.estimate.velocity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class VelocityOfDayTest {

    /**
     * Method under test: {@link VelocityOfDay#getValue()}
     */
    @Test
    void testGetValue() {
        // Arrange
        int value = 42;
        EffortOfSprint effort = EffortOfSprint.of(value);
        int value1 = 42;
        DaysOfSprint days = DaysOfSprint.of(value1);
        VelocityOfDay createResult = VelocityOfDay.create(effort, days);

        // Act
        BigDecimal actualValue = createResult.getValue();

        // Assert
        String expectedToStringResult = "1";
        String actualToStringResult = actualValue.toString();
        assertEquals(expectedToStringResult, actualToStringResult);
    }

    /**
     * Method under test: {@link VelocityOfDay#getValue()}
     */
    @Test
    void testGetValue2() {
        // Arrange
        int value = 0;
        EffortOfSprint effort = EffortOfSprint.of(value);
        int value1 = 42;
        DaysOfSprint days = DaysOfSprint.of(value1);
        VelocityOfDay createResult = VelocityOfDay.create(effort, days);

        // Act
        BigDecimal actualValue = createResult.getValue();

        // Assert
        BigDecimal expectedValue = actualValue.ZERO;
        assertSame(expectedValue, actualValue);
        String expectedToStringResult = "0";
        String actualToStringResult = actualValue.toString();
        assertEquals(expectedToStringResult, actualToStringResult);
    }

}

