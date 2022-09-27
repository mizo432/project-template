package org.venusPj.projectTemplate.learning.valueObject.arg.source;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.learning.valueObject.arg.step01.AgeComputer;

class AgeComputerTest {

    /**
     * Method under test: {@link AgeComputer#computeAge(LocalDate, LocalDate)}
     */
    @Test
    void testGetAge() throws IllegalArgumentException {
        // Arrange
        AgeComputer ageComputer = new AgeComputer();
        long epochDay = 1L;
        LocalDate birthDate = LocalDate.ofEpochDay(epochDay);
        long epochDay1 = 1L;
        LocalDate targetDate = LocalDate.ofEpochDay(epochDay1);

        // Act
        int actualAge = ageComputer.computeAge(birthDate, targetDate);

        // Assert
        int expectedAge = 0;
        assertEquals(expectedAge, actualAge);
    }

    /**
     * Method under test: {@link AgeComputer#computeAge(LocalDate, LocalDate)}
     */
    @Test
    void testGetAge2() throws IllegalArgumentException {
        // Arrange
        AgeComputer ageComputer = new AgeComputer();
        LocalDate birthDate = null;
        LocalDate targetDate = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> ageComputer.computeAge(birthDate, targetDate));
    }

    /**
     * Method under test: {@link AgeComputer#computeAge(LocalDate, LocalDate)}
     */
    @Test
    void testGetAge3() throws IllegalArgumentException {
        // Arrange
        AgeComputer ageComputer = new AgeComputer();
        long epochDay = 2L;
        LocalDate birthDate = LocalDate.ofEpochDay(epochDay);
        long epochDay1 = 1L;
        LocalDate targetDate = LocalDate.ofEpochDay(epochDay1);

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> ageComputer.computeAge(birthDate, targetDate));
    }

    /**
     * Method under test: {@link AgeComputer#computeAge(LocalDate, LocalDate)}
     */
    @Test
    void testGetAge4() throws IllegalArgumentException {
        // Arrange
        AgeComputer ageComputer = new AgeComputer();
        long epochDay = -1L;
        LocalDate birthDate = LocalDate.ofEpochDay(epochDay);
        long epochDay1 = 1L;
        LocalDate targetDate = LocalDate.ofEpochDay(epochDay1);

        // Act
        int actualAge = ageComputer.computeAge(birthDate, targetDate);

        // Assert
        int expectedAge = 0;
        assertEquals(expectedAge, actualAge);
    }

    /**
     * Method under test: {@link AgeComputer#computeAge(LocalDate, LocalDate)}
     */
    @Test
    void testGetAge5() throws IllegalArgumentException {
        // Arrange
        AgeComputer ageComputer = new AgeComputer();
        long epochDay = 1L;
        LocalDate birthDate = LocalDate.ofEpochDay(epochDay);
        LocalDate targetDate = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> ageComputer.computeAge(birthDate, targetDate));
    }

    /**
     * Method under test: {@link AgeComputer#computeAge(LocalDate, LocalDate)}
     */
    @Test
    void testGetAge6() throws IllegalArgumentException {
        // Arrange
        AgeComputer ageComputer = new AgeComputer();
        int year = 12;
        int dayOfYear = 12;
        LocalDate birthDate = LocalDate.ofYearDay(year, dayOfYear);
        long epochDay = 1L;
        LocalDate targetDate = LocalDate.ofEpochDay(epochDay);

        // Act
        int actualAge = ageComputer.computeAge(birthDate, targetDate);

        // Assert
        int expectedAge = 1957;
        assertEquals(expectedAge, actualAge);
    }

    /**
     * Method under test: {@link AgeComputer#computeAge(LocalDate, LocalDate)}
     */
    @Test
    void testGetAge7() throws IllegalArgumentException {
        // Arrange
        AgeComputer ageComputer = new AgeComputer();
        int year = 12;
        int dayOfYear = 12;
        LocalDate birthDate = LocalDate.ofYearDay(year, dayOfYear);
        long epochDay = -1L;
        LocalDate targetDate = LocalDate.ofEpochDay(epochDay);

        // Act
        int actualAge = ageComputer.computeAge(birthDate, targetDate);

        // Assert
        int expectedAge = 1957;
        assertEquals(expectedAge, actualAge);
    }
}

