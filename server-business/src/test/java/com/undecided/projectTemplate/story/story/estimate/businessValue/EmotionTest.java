package com.undecided.projectTemplate.story.story.estimate.businessValue;

import com.undecided.projectTemplate.story.domain.story.estimate.businessValue.Emotion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmotionTest {

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Emotion#valueOf(String)}
     *   <li>{@link Emotion#getDisplayName()}
     * </ul>
     */
    @Test
    void testValueOf() {
        // Arrange
        String name = "EXPECT_IT";

        // Act
        Emotion actualValueOfResult = Emotion.valueOf(name);

        // Assert
        String expectedDisplayName = "魅力的";
        String actualDisplayName = actualValueOfResult.getDisplayName();
        assertEquals(expectedDisplayName, actualDisplayName);
    }
}

