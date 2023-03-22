package com.undecided.projectTemplate.shared.entity.id;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.undecided.projectTemplate.example.domain.employee.Employee;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class IdentifiersTest {

    /**
     * Method under test: {@link Identifiers#of(Collection)}
     */
    @Test
    void testOf() {
        // Arrange
        ArrayList<Employee> employeeList = new ArrayList<>();

        // Act and Assert
        assertTrue(Identifiers.of(employeeList).getValue().isEmpty());
        assertTrue(employeeList.isEmpty());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Identifiers#Identifiers()}
     *   <li>{@link Identifiers#getValue()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        Identifiers<Employee> actualIdentifiers = new Identifiers<>();

        // Assert
        assertTrue(actualIdentifiers.getValue().isEmpty());
        assertTrue(actualIdentifiers.isEmpty());
    }

    /**
     * Method under test: {@link Identifiers#isEmpty()}
     */
    @Test
    void testIsEmpty() {
        // Arrange, Act and Assert
        assertTrue((new Identifiers<>()).isEmpty());
    }

    /**
     * Method under test: {@link Identifiers#Identifiers()}
     */
    @Test
    void testConstructor2() {
        // Arrange, Act and Assert
        assertTrue((new Identifiers<>()).getValue().isEmpty());
    }

    /**
     * Method under test: {@link Identifiers#Identifiers(Collection)}
     */
    @Test
    void testConstructor3() {
        // Arrange
        ArrayList<Employee> employeeList = new ArrayList<>();

        // Act and Assert
        assertTrue((new Identifiers<>(employeeList)).getValue().isEmpty());
        assertTrue(employeeList.isEmpty());
    }
}

