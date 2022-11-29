package org.venusPj.primitive.intMath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.RoundingMode;
import org.junit.jupiter.api.Test;
import org.venusPj.primitive.intMath.IntMath;

class IntMathTest {

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide() {
        // Arrange
        int p = 1;
        int q = 1;
        RoundingMode roundingMode = RoundingMode.UP;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide2() {
        // Arrange
        int p = 1;
        int q = 0;
        RoundingMode roundingMode = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> IntMath.divide(p, q, roundingMode));
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide3() {
        // Arrange
        int p = 1;
        int q = 0;
        RoundingMode roundingMode = RoundingMode.UP;

        // Act and Assert
        assertThrows(ArithmeticException.class, () -> IntMath.divide(p, q, roundingMode));
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide4() {
        // Arrange
        int p = 1;
        int q = Integer.MIN_VALUE;
        RoundingMode roundingMode = RoundingMode.UP;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = -1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide5() {
        // Arrange
        int p = 1;
        int q = 1;
        RoundingMode roundingMode = RoundingMode.DOWN;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide6() {
        // Arrange
        int p = 1;
        int q = 1;
        RoundingMode roundingMode = RoundingMode.CEILING;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide7() {
        // Arrange
        int p = 1;
        int q = 1;
        RoundingMode roundingMode = RoundingMode.FLOOR;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide8() {
        // Arrange
        int p = 1;
        int q = Integer.MIN_VALUE;
        RoundingMode roundingMode = RoundingMode.DOWN;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 0;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide9() {
        // Arrange
        int p = 1;
        int q = Integer.MIN_VALUE;
        RoundingMode roundingMode = RoundingMode.CEILING;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 0;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide10() {
        // Arrange
        int p = 1;
        int q = Integer.MIN_VALUE;
        RoundingMode roundingMode = RoundingMode.FLOOR;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = -1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide11() {
        // Arrange
        int p = 1;
        int q = 1;
        RoundingMode roundingMode = RoundingMode.HALF_UP;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide12() {
        // Arrange
        int p = 1;
        int q = 2;
        RoundingMode roundingMode = RoundingMode.CEILING;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide13() {
        // Arrange
        int p = 1;
        int q = 2;
        RoundingMode roundingMode = RoundingMode.FLOOR;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 0;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide14() {
        // Arrange
        int p = 1;
        int q = Integer.MIN_VALUE;
        RoundingMode roundingMode = RoundingMode.HALF_UP;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 0;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide15() {
        // Arrange
        int p = 1;
        int q = 2;
        RoundingMode roundingMode = RoundingMode.HALF_UP;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide16() {
        // Arrange
        int p = 1;
        int q = 1;
        RoundingMode roundingMode = RoundingMode.HALF_DOWN;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide17() {
        // Arrange
        int p = 1;
        int q = 2;
        RoundingMode roundingMode = RoundingMode.HALF_DOWN;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 0;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide18() {
        // Arrange
        int p = 31;
        int q = 2;
        RoundingMode roundingMode = RoundingMode.HALF_DOWN;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 15;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide19() {
        // Arrange
        int p = 31;
        int q = 4;
        RoundingMode roundingMode = RoundingMode.HALF_DOWN;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 8;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide20() {
        // Arrange
        int p = 1;
        int q = 1;
        RoundingMode roundingMode = RoundingMode.HALF_EVEN;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide21() {
        // Arrange
        int p = 1;
        int q = 2;
        RoundingMode roundingMode = RoundingMode.HALF_EVEN;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 0;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide22() {
        // Arrange
        int p = 31;
        int q = 2;
        RoundingMode roundingMode = RoundingMode.HALF_EVEN;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = Short.SIZE;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide23() {
        // Arrange
        int p = 1;
        int q = 1;
        RoundingMode roundingMode = RoundingMode.UNNECESSARY;

        // Act
        int actualDivideResult = IntMath.divide(p, q, roundingMode);

        // Assert
        int expectedDivideResult = 1;
        assertEquals(expectedDivideResult, actualDivideResult);
    }

    /**
     * Method under test: {@link IntMath#divide(int, int, RoundingMode)}
     */
    @Test
    void testDivide24() {
        // Arrange
        int p = 1;
        int q = Integer.MIN_VALUE;
        RoundingMode roundingMode = RoundingMode.UNNECESSARY;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> IntMath.divide(p, q, roundingMode));
    }
}

