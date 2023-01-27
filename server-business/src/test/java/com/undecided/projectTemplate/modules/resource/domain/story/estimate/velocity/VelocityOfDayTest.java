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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.venusPj.projectTemplate.modules.core.domain.velocity.EffortOfSprint.isZero()" because "this.effort" is null
        //       at org.venusPj.projectTemplate.modules.core.domain.velocity.VelocityOfDay.getValue(VelocityOfDay.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArithmeticException: / by zero
        //       at java.math.BigDecimal.divideAndRound(BigDecimal.java:4642)
        //       at java.math.BigDecimal.divide(BigDecimal.java:5715)
        //       at java.math.BigDecimal.divide(BigDecimal.java:1636)
        //       at java.math.BigDecimal.divide(BigDecimal.java:1666)
        //       at org.venusPj.projectTemplate.modules.core.domain.velocity.VelocityOfDay.getValue(VelocityOfDay.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.venusPj.projectTemplate.modules.core.domain.velocity.DaysOfSprint.getValue()" because "this.days" is null
        //       at org.venusPj.projectTemplate.modules.core.domain.velocity.VelocityOfDay.getValue(VelocityOfDay.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        int value = 42;
        EffortOfSprint effort = EffortOfSprint.of(value);
        DaysOfSprint days = null;
        VelocityOfDay createResult = VelocityOfDay.create(effort, days);

        // Act
        createResult.getValue();
    }
}

