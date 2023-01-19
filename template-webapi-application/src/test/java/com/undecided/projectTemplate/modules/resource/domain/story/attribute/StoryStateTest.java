package com.undecided.projectTemplate.modules.resource.domain.story.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.undecided.projectTemplate.shared.value.ValueNotFoundException;
import org.junit.jupiter.api.Test;

class StoryStateTest {

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StoryState#valueOf(String)}
     *   <li>{@link StoryState#getBoxName()}
     * </ul>
     */
    @Test
    void testValueOf() {
        // Arrange
        String name = "SUGGESTED";

        // Act
        StoryState actualValueOfResult = StoryState.valueOf(name);

        // Assert
        String expectedBoxName = "sandbox";
        String actualBoxName = actualValueOfResult.getBoxName();
        assertEquals(expectedBoxName, actualBoxName);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StoryState#valueOf(String)}
     *   <li>{@link StoryState#getDescription()}
     * </ul>
     */
    @Test
    void testValueOf2() {
        // Arrange
        String name = "SUGGESTED";

        // Act
        StoryState actualValueOfResult = StoryState.valueOf(name);

        // Assert
        String expectedBoxName = "sandbox";
        String actualBoxName = actualValueOfResult.getBoxName();
        assertEquals(expectedBoxName, actualBoxName);
        String expectedValue = "検討中、業務的価値を検討中";
        Description description = actualValueOfResult.getDescription();
        String actualValue = description.getValue();
        assertEquals(expectedValue, actualValue);
    }

    /**
     * Method under test: {@link StoryState#valueOfStateId(Integer)}
     */
    @Test
    void testValueOfStateId() {
        // Arrange
        int stateId = 123;

        // Act and Assert
        assertThrows(ValueNotFoundException.class, () -> StoryState.valueOfStateId(stateId));
    }

    /**
     * Method under test: {@link StoryState#valueOfStateId(Integer)}
     */
    @Test
    void testValueOfStateId3() {
        // Arrange
        int stateId = 7;

        // Act
        StoryState actualValueOfStateIdResult = StoryState.valueOfStateId(stateId);

        // Assert
        StoryState expectedValueOfStateIdResult = StoryState.DONE;
        assertEquals(expectedValueOfStateIdResult, actualValueOfStateIdResult);
    }

    /**
     * Method under test: {@link StoryState#valueOfStateId(Integer)}
     */
    @Test
    void testValueOfStateId4() {
        // Arrange
        int stateId = 1;

        // Act
        StoryState actualValueOfStateIdResult = StoryState.valueOfStateId(stateId);

        // Assert
        StoryState expectedValueOfStateIdResult = StoryState.SUGGESTED;
        assertEquals(expectedValueOfStateIdResult, actualValueOfStateIdResult);
    }

    /**
     * Method under test: {@link StoryState#valueOfStateId(Integer)}
     */
    @Test
    void testValueOfStateId5() {
        // Arrange
        int stateId = 2;

        // Act
        StoryState actualValueOfStateIdResult = StoryState.valueOfStateId(stateId);

        // Assert
        StoryState expectedValueOfStateIdResult = StoryState.ACCEPTED;
        assertEquals(expectedValueOfStateIdResult, actualValueOfStateIdResult);
    }

    /**
     * Method under test: {@link StoryState#valueOfStateId(Integer)}
     */
    @Test
    void testValueOfStateId6() {
        // Arrange
        int stateId = 3;

        // Act
        StoryState actualValueOfStateIdResult = StoryState.valueOfStateId(stateId);

        // Assert
        StoryState expectedValueOfStateIdResult = StoryState.ESTIMATED;
        assertEquals(expectedValueOfStateIdResult, actualValueOfStateIdResult);
    }

    /**
     * Method under test: {@link StoryState#valueOfStateId(Integer)}
     */
    @Test
    void testValueOfStateId7() {
        // Arrange
        int stateId = 4;

        // Act
        StoryState actualValueOfStateIdResult = StoryState.valueOfStateId(stateId);

        // Assert
        StoryState expectedValueOfStateIdResult = StoryState.PLANNED;
        assertEquals(expectedValueOfStateIdResult, actualValueOfStateIdResult);
    }

    /**
     * Method under test: {@link StoryState#valueOfStateId(Integer)}
     */
    @Test
    void testValueOfStateId8() {
        // Arrange
        int stateId = -1;

        // Act
        StoryState actualValueOfStateIdResult = StoryState.valueOfStateId(stateId);

        // Assert
        StoryState expectedValueOfStateIdResult = StoryState.FROZEN;
        assertEquals(expectedValueOfStateIdResult, actualValueOfStateIdResult);
    }

    /**
     * Method under test: {@link StoryState#valueOfStateId(Integer)}
     */
    @Test
    void testValueOfStateId9() {
        // Arrange
        int stateId = 5;

        // Act
        StoryState actualValueOfStateIdResult = StoryState.valueOfStateId(stateId);

        // Assert
        StoryState expectedValueOfStateIdResult = StoryState.IN_PROGRESS;
        assertEquals(expectedValueOfStateIdResult, actualValueOfStateIdResult);
    }

    /**
     * Method under test: {@link StoryState#valueOfStateId(Integer)}
     */
    @Test
    void testValueOfStateId10() {
        // Arrange
        int stateId = 6;

        // Act
        StoryState actualValueOfStateIdResult = StoryState.valueOfStateId(stateId);

        // Assert
        StoryState expectedValueOfStateIdResult = StoryState.IN_REVIEW;
        assertEquals(expectedValueOfStateIdResult, actualValueOfStateIdResult);
    }
}

