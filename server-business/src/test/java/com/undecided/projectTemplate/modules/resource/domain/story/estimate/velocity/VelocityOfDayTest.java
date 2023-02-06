package com.undecided.projectTemplate.modules.resource.domain.story.estimate.velocity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;
import org.junit.jupiter.api.Disabled;
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
        String expectedToStringResult = "1.00";
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

    /**
     * Method under test: {@link VelocityOfDay#getValue()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetValue3() {

        // Arrange
        EffortOfSprint effort = null;
        int value = 42;
        DaysOfSprint days = DaysOfSprint.of(value);
        VelocityOfDay createResult = VelocityOfDay.create(effort, days);

        // Act
        createResult.getValue();
    }

    /**
     * Method under test: {@link VelocityOfDay#getValue()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetValue4() {

        // Arrange
        int value = 42;
        EffortOfSprint effort = EffortOfSprint.of(value);
        int value1 = 0;
        DaysOfSprint days = DaysOfSprint.of(value1);
        VelocityOfDay createResult = VelocityOfDay.create(effort, days);

        // Act
        createResult.getValue();
    }

    /**
     * Method under test: {@link VelocityOfDay#getValue()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetValue5() {

        // Arrange
        int value = 42;
        EffortOfSprint effort = EffortOfSprint.of(value);
        DaysOfSprint days = null;
        VelocityOfDay createResult = VelocityOfDay.create(effort, days);

        // Act
        createResult.getValue();
    }
}

