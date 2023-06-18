package template.modules.story.estimate.businessValue;

import org.junit.jupiter.api.Test;
import template.modules.story.domain.model.estimate.businessValue.BusinessQuality;
import template.modules.story.domain.model.estimate.businessValue.Emotion;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusinessQualityTest {

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom() {
        // Arrange
        Emotion functionalEmotion = Emotion.EXPECT_IT;
        Emotion dysfunctionalEmotion = Emotion.EXPECT_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.UNKNOWN;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom2() {
        // Arrange
        Emotion functionalEmotion = Emotion.LIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.EXPECT_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.REVERSE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom3() {
        // Arrange
        Emotion functionalEmotion = Emotion.NATURAL;
        Emotion dysfunctionalEmotion = Emotion.EXPECT_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.REVERSE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom4() {
        // Arrange
        Emotion functionalEmotion = Emotion.CAN_TOLERATE_IT;
        Emotion dysfunctionalEmotion = Emotion.EXPECT_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.REVERSE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom5() {
        // Arrange
        Emotion functionalEmotion = Emotion.EXPECT_IT;
        Emotion dysfunctionalEmotion = Emotion.LIKE_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.ATTRACTIVE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom6() {
        // Arrange
        Emotion functionalEmotion = Emotion.DISLIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.EXPECT_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.REVERSE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom7() {
        // Arrange
        Emotion functionalEmotion = Emotion.LIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.LIKE_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.INDIFFERENT;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom8() {
        // Arrange
        Emotion functionalEmotion = Emotion.EXPECT_IT;
        Emotion dysfunctionalEmotion = Emotion.DISLIKE_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.ONE_DIMENSIONAL;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom9() {
        // Arrange
        Emotion functionalEmotion = Emotion.DISLIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.LIKE_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.REVERSE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom10() {
        // Arrange
        Emotion functionalEmotion = Emotion.LIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.DISLIKE_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.MUST_BE;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }

    /**
     * Method under test: {@link BusinessQuality#computeFrom(Emotion, Emotion)}
     */
    @Test
    void testComputeFrom11() {
        // Arrange
        Emotion functionalEmotion = Emotion.DISLIKE_IT;
        Emotion dysfunctionalEmotion = Emotion.DISLIKE_IT;

        // Act
        BusinessQuality actualComputeFromResult = BusinessQuality.computeFrom(functionalEmotion,
                dysfunctionalEmotion);

        // Assert
        BusinessQuality expectedComputeFromResult = BusinessQuality.UNKNOWN;
        assertEquals(expectedComputeFromResult, actualComputeFromResult);
    }
}

