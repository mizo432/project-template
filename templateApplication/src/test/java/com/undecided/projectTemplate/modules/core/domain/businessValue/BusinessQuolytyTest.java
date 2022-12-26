package com.undecided.projectTemplate.modules.core.domain.businessValue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BusinessQuolytyTest {

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom() {
        // Arrange
        Emotion functionalEmotion = Emotion.EXPECT_IT;
        Emotion dysfunctionalEmotion = Emotion.EXPECT_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.UNKNOWN;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom2() {
        // Arrange
        Emotion functionalEmotion = Emotion.LIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.EXPECT_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.REVERSE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom3() {
        // Arrange
        Emotion functionalEmotion = Emotion.NATURAL;
        Emotion dysfunctionalEmotion = Emotion.EXPECT_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.REVERSE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom4() {
        // Arrange
        Emotion functionalEmotion = Emotion.CAN_TOLERATE_IT;
        Emotion dysfunctionalEmotion = Emotion.EXPECT_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.REVERSE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom5() {
        // Arrange
        Emotion functionalEmotion = Emotion.EXPECT_IT;
        Emotion dysfunctionalEmotion = Emotion.LIKE_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.ATTRACTIVE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom6() {
        // Arrange
        Emotion functionalEmotion = Emotion.DISLIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.EXPECT_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.REVERSE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom7() {
        // Arrange
        Emotion functionalEmotion = Emotion.LIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.LIKE_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.INDIFFERENT;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom8() {
        // Arrange
        Emotion functionalEmotion = Emotion.EXPECT_IT;
        Emotion dysfunctionalEmotion = Emotion.DISLIKE_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.ONE_DIMENSIONAL;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom9() {
        // Arrange
        Emotion functionalEmotion = Emotion.DISLIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.LIKE_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.REVERSE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom10() {
        // Arrange
        Emotion functionalEmotion = Emotion.LIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.DISLIKE_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.MUST_BE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuolyty#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom11() {
        // Arrange
        Emotion functionalEmotion = Emotion.DISLIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.DISLIKE_IT;

        // Act
        BusinessQuolyty actualComputeFromResult = BusinessQuolyty.computeFrom(functionalEmotion,
            dysfunctionalEmotion);

        // Assert
        BusinessQuolyty expectedComputeFromResult = BusinessQuolyty.UNKNOWN;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }
}

