package org.venusPj.projectTemplate.learning.valueObject.arg.step04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class BirthDateTest {

    /**
     * Method under test: {@link BirthDate#of(LocalDate)}
     */
    @Test
    void testOf() {
        // Arrange
        LocalDate birthDate = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> BirthDate.of(
                birthDate));
    }

    /**
     * Method under test: {@link BirthDate#asLocalDate()}
     */
    @Test
    void testAsLocalDate() {
        // Arrange
        long epochDay = 1L;
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(epochDay);
        BirthDate ofResult = BirthDate.of(
            ofEpochDayResult);

        // Act
        LocalDate actualAsLocalDateResult = ofResult.asLocalDate();

        // Assert
        assertSame(ofEpochDayResult, actualAsLocalDateResult);
        String expectedToStringResult = "1970-01-02";
        String actualToStringResult = actualAsLocalDateResult.toString();
        assertEquals(expectedToStringResult, actualToStringResult);
    }
}

