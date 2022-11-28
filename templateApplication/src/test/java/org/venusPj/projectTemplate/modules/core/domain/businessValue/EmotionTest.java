package org.venusPj.projectTemplate.modules.core.domain.businessValue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.shared.test.TestSize;

@Tag(TestSize.SMALL)
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

