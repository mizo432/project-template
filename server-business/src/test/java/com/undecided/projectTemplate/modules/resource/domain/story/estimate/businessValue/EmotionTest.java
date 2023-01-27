package com.undecided.projectTemplate.modules.resource.domain.story.estimate.businessValue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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

