package org.venusPj.projectTemplate.modules.resource.domain.project.attribute;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.modules.resource.domain.story.attribute.Description;

class ProjectAttributeTest {

    /**
     * Method under test:
     * {@link ProjectAttribute#create(ProjectName, ProjectCode, StoryCodePrefix)}
     */
    @Test
    void testCreate() {
        // Arrange
        String value = "42";
        ProjectName ofResult = ProjectName.of(value);
        String value1 = "42";
        ProjectCode ofResult1 = ProjectCode.of(value1);
        String value2 = "42";
        StoryCodePrefix ofResult2 = StoryCodePrefix.of(value2);

        // Act
        ProjectAttribute actualCreateResult = ProjectAttribute.create(ofResult, ofResult1,
            ofResult2, Description.of("A"));

        System.out.println(actualCreateResult);

        // Assert
        ProjectCode actualCode = actualCreateResult.getProjectCode();
        assertSame(ofResult1, actualCode);
        StoryCodePrefix actualStoryCodePrefix = actualCreateResult.getStoryCodePrefix();
        assertSame(ofResult2, actualStoryCodePrefix);
        ProjectName actualName = actualCreateResult.getProjectName();
        assertSame(ofResult, actualName);
    }
}

