package com.undecided.projectTemplate.modules.resource.domain.story.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StoryAttributeTest {

    /**
     * Method under test:
     * {@link StoryAttribute#reconstruct(String, String, String, StoryType, StoryStatus)}
     */
    @Test
    void testReconstruct() {
        // Arrange
        String code = "Code";
        String name = "Name";
        String description = "The characteristics of someone or something";
        StoryType type = StoryType.ユーザーストーリー;
        StoryStatus status = StoryStatus.凍結;

        // Act
        StoryAttribute actualReconstructResult = StoryAttribute.reconstruct(code, name, description,
            type, status);

        // Assert
        StoryType expectedType = StoryType.ユーザーストーリー;
        StoryType actualType = actualReconstructResult.getType();
        assertEquals(expectedType, actualType);
        StoryStatus expectedStatus = StoryStatus.凍結;
        StoryStatus actualStatus = actualReconstructResult.getStatus();
        assertEquals(expectedStatus, actualStatus);
        String expectedValue = "The characteristics of someone or something";
        Description description1 = actualReconstructResult.getDescription();
        String actualValue = description1.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "Name";
        StoryName name1 = actualReconstructResult.getName();
        String actualValue1 = name1.getValue();
        assertEquals(expectedValue1, actualValue1);
        String expectedValue2 = "Code";
        StoryCode code1 = actualReconstructResult.getCode();
        String actualValue2 = code1.getValue();
        assertEquals(expectedValue2, actualValue2);
    }

    /**
     * Method under test:
     * {@link StoryAttribute#reconstruct(String, String, String, StoryType, StoryStatus)}
     */
    @Test
    void testReconstruct2() {
        // Arrange
        String code = "Code";
        String name = "Name";
        String description = "The characteristics of someone or something";
        StoryType type = StoryType.分割ストーリー;
        StoryStatus status = StoryStatus.凍結;

        // Act
        StoryAttribute actualReconstructResult = StoryAttribute.reconstruct(code, name, description,
            type, status);

        // Assert
        StoryType expectedType = StoryType.分割ストーリー;
        StoryType actualType = actualReconstructResult.getType();
        assertEquals(expectedType, actualType);
        StoryStatus expectedStatus = StoryStatus.凍結;
        StoryStatus actualStatus = actualReconstructResult.getStatus();
        assertEquals(expectedStatus, actualStatus);
        String expectedValue = "The characteristics of someone or something";
        Description description1 = actualReconstructResult.getDescription();
        String actualValue = description1.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "Name";
        StoryName name1 = actualReconstructResult.getName();
        String actualValue1 = name1.getValue();
        assertEquals(expectedValue1, actualValue1);
        String expectedValue2 = "Code";
        StoryCode code1 = actualReconstructResult.getCode();
        String actualValue2 = code1.getValue();
        assertEquals(expectedValue2, actualValue2);
    }

    /**
     * Method under test:
     * {@link StoryAttribute#reconstruct(String, String, String, StoryType, StoryStatus)}
     */
    @Test
    void testReconstruct3() {
        // Arrange
        String code = "Code";
        String name = "Name";
        String description = "The characteristics of someone or something";
        StoryType type = StoryType.技術検証;
        StoryStatus status = StoryStatus.凍結;

        // Act
        StoryAttribute actualReconstructResult = StoryAttribute.reconstruct(code, name, description,
            type, status);

        // Assert
        StoryType expectedType = StoryType.技術検証;
        StoryType actualType = actualReconstructResult.getType();
        assertEquals(expectedType, actualType);
        StoryStatus expectedStatus = StoryStatus.凍結;
        StoryStatus actualStatus = actualReconstructResult.getStatus();
        assertEquals(expectedStatus, actualStatus);
        String expectedValue = "The characteristics of someone or something";
        Description description1 = actualReconstructResult.getDescription();
        String actualValue = description1.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "Name";
        StoryName name1 = actualReconstructResult.getName();
        String actualValue1 = name1.getValue();
        assertEquals(expectedValue1, actualValue1);
        String expectedValue2 = "Code";
        StoryCode code1 = actualReconstructResult.getCode();
        String actualValue2 = code1.getValue();
        assertEquals(expectedValue2, actualValue2);
    }

    /**
     * Method under test:
     * {@link StoryAttribute#reconstruct(String, String, String, StoryType, StoryStatus)}
     */
    @Test
    void testReconstruct4() {
        // Arrange
        String code = "Code";
        String name = "Name";
        String description = "The characteristics of someone or something";
        StoryType type = StoryType.障害対応;
        StoryStatus status = StoryStatus.凍結;

        // Act
        StoryAttribute actualReconstructResult = StoryAttribute.reconstruct(code, name, description,
            type, status);

        System.out.println(actualReconstructResult);

        // Assert
        StoryType expectedType = StoryType.障害対応;
        StoryType actualType = actualReconstructResult.getType();
        assertEquals(expectedType, actualType);
        StoryStatus expectedStatus = StoryStatus.凍結;
        StoryStatus actualStatus = actualReconstructResult.getStatus();
        assertEquals(expectedStatus, actualStatus);
        String expectedValue = "The characteristics of someone or something";
        Description description1 = actualReconstructResult.getDescription();
        String actualValue = description1.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "Name";
        StoryName name1 = actualReconstructResult.getName();
        String actualValue1 = name1.getValue();
        assertEquals(expectedValue1, actualValue1);
        String expectedValue2 = "Code";
        StoryCode code1 = actualReconstructResult.getCode();
        String actualValue2 = code1.getValue();
        assertEquals(expectedValue2, actualValue2);
    }
}

