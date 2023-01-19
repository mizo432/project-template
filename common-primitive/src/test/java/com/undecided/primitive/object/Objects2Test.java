package com.undecided.primitive.object;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Objects2Test {

    /**
     * Method under test: {@link Objects2#isNull(Object)}
     */
    @Test
    void testIsNull() {
        // Arrange
        String refernce = "Refernce";

        // Act
        boolean actualIsNullResult = Objects2.isNull(refernce);

        // Assert
        boolean expectedIsNullResult = false;
        assertEquals(expectedIsNullResult, actualIsNullResult);
    }

    /**
     * Method under test: {@link Objects2#isNull(Object)}
     */
    @Test
    void testIsNull2() {
        // Arrange
        Object refernce = null;

        // Act
        boolean actualIsNullResult = Objects2.isNull(refernce);

        // Assert
        boolean expectedIsNullResult = true;
        assertEquals(expectedIsNullResult, actualIsNullResult);
    }
}

