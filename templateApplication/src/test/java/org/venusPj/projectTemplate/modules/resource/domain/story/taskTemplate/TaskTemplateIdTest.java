package org.venusPj.projectTemplate.modules.resource.domain.story.taskTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TaskTemplateIdTest {

    /**
     * Method under test: {@link TaskTemplateId#reconstruct(String)}
     */
    @Test
    void testReconstruct() {
        // Arrange
        String value = "42";

        // Act
        TaskTemplateId actualReconstructResult = TaskTemplateId.reconstruct(value);

        // Assert
        String expectedValue = "42";
        String actualValue = actualReconstructResult.getValue();
        assertEquals(expectedValue, actualValue);
    }
}

