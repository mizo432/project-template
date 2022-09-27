package org.venusPj.projectTemplate.learning.valueObject.step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.learning.valueObject.field.step2.SourceClass;

class SourceClassTest {

    /**
     * Method under test: {@link SourceClass#amount()}
     */
    @Test
    void testAmount() {
        // Arrange
        long quantity = 3L;
        long price = 2L;
        SourceClass sourceClass = new SourceClass(quantity, price);

        // Act
        Long actualAmountResult = sourceClass.amount();

        // Assert
        long expectedLongValueResult = 6L;
        long actualLongValueResult = actualAmountResult.longValue();
        assertEquals(expectedLongValueResult, actualLongValueResult);
    }
}

