package com.undecided.projectTemplate.resource.domain.partyRole.user.attribbute;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserCodeTest {

    /**
     * Method under test: {@link UserCode#asString()}
     */
    @Test
    void testAsString() {
        // Arrange
        String value = "42";
        UserCode ofResult = UserCode.of(value);

        // Act
        String actualAsStringResult = ofResult.asString();

        // Assert
        String expectedAsStringResult = "42";
        assertEquals(expectedAsStringResult, actualAsStringResult);
    }

    /**
     * Method under test: {@link UserCode#of(String)}
     */
    @Test
    void testOf() {
        // Arrange
        String value = "42";

        // Act
        UserCode actualOfResult = UserCode.of(value);

        // Assert
        String expectedValue = "42";
        String actualValue = actualOfResult.getValue();
        assertEquals(expectedValue, actualValue);
    }

    /**
     * Method under test: {@link UserCode#reconstruct(String)}
     */
    @Test
    void testReconstruct() {
        // Arrange
        String value = "42";

        // Act
        UserCode actualReconstructResult = UserCode.reconstruct(value);

        // Assert
        String expectedValue = "42";
        String actualValue = actualReconstructResult.getValue();
        assertEquals(expectedValue, actualValue);
    }
}

