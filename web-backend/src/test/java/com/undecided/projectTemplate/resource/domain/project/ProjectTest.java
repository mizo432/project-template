package com.undecided.projectTemplate.resource.domain.project;

import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.project.domain.model.project.attribute.ProjectAttribute;
import com.undecided.projectTemplate.project.domain.model.project.attribute.ProjectCode;
import com.undecided.projectTemplate.project.domain.model.project.attribute.ProjectName;
import com.undecided.projectTemplate.project.domain.model.project.attribute.StoryCodePrefix;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import com.undecided.projectTemplate.shared.type.description.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ProjectTest {

    /**
     * Method under test: {@link Project#Project(SnowflakeId, ProjectAttribute)}
     */
    @Test
    void testConstructor() {
        // Arrange
        SnowflakeId<Project> newInstanceResult = SnowflakeId.newInstance();
        String value = "42";
        ProjectName ofResult = ProjectName.of(value);
        String value1 = "42";
        ProjectCode ofResult1 = ProjectCode.of(value1);
        String value2 = "42";
        StoryCodePrefix ofResult2 = StoryCodePrefix.of(value2);
        ProjectAttribute createResult = ProjectAttribute.create(ofResult, ofResult1, ofResult2,
                Description.of("A"));

        // Act
        Project actualProject = new Project(newInstanceResult, AuditInfo.empty(), createResult);

        System.out.println(actualProject);

        // Assert
        ProjectAttribute attribute = actualProject.getAttribute();
        assertSame(createResult, attribute);
        SnowflakeId<Project> actualId = actualProject.getId();
        assertSame(newInstanceResult, actualId);
        StoryCodePrefix storyCodePrefix = attribute.getStoryCodePrefix();
        assertSame(ofResult2, storyCodePrefix);
        ProjectName name = attribute.getProjectName();
        assertSame(ofResult, name);
        ProjectCode code = attribute.getProjectCode();
        assertSame(ofResult1, code);
        String expectedValue = "42";
        String actualValue = name.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "42";
        String actualValue1 = code.getValue();
        assertEquals(expectedValue1, actualValue1);
        String expectedValue3 = "42";
        String actualValue3 = storyCodePrefix.getValue();
        assertEquals(expectedValue3, actualValue3);
    }

    /**
     * Method under test: {@link Project#create(Project)}
     */
    @Test
    void testCreate() {
        // Arrange
        String value = "42";
        ProjectName name = ProjectName.of(value);
        String value1 = "42";
        ProjectCode code = ProjectCode.of(value1);
        String value2 = "42";
        StoryCodePrefix storyCodePrefix = StoryCodePrefix.of(value2);
        ProjectAttribute createResult = ProjectAttribute.create(name, code, storyCodePrefix,
                Description.of("A"));
        Project project = Project.create(createResult);
        Project project1 = Project.create(project);
        Project project2 = Project.create(project1);
        Project project3 = Project.create(project2);
        Project project4 = Project.create(project3);
        Project project5 = Project.create(project4);

        // Act
        Project actualCreateResult = Project.create(project5);

        // Assert
        ProjectAttribute actualAttribute = actualCreateResult.getAttribute();
        assertSame(createResult, actualAttribute);
    }

    /**
     * Method under test: {@link Project#create(ProjectAttribute)}
     */
    @Test
    void testCreate3() {
        // Arrange
        String value = "42";
        ProjectName name = ProjectName.of(value);
        String value1 = "42";
        ProjectCode code = ProjectCode.of(value1);
        String value2 = "42";
        StoryCodePrefix storyCodePrefix = StoryCodePrefix.of(value2);
        ProjectAttribute createResult = ProjectAttribute.create(name, code, storyCodePrefix,
                Description.of("A"));

        // Act
        Project actualCreateResult = Project.create(createResult);

        // Assert
        ProjectAttribute actualAttribute = actualCreateResult.getAttribute();
        assertSame(createResult, actualAttribute);
    }

    /**
     * Method under test: {@link Project#sameValueAs(Project)}
     */
    @Test
    void testSameValueAs() {
        // Arrange
        String value = "42";
        ProjectName name = ProjectName.of(value);
        String value1 = "42";
        ProjectCode code = ProjectCode.of(value1);
        String value2 = "42";
        StoryCodePrefix storyCodePrefix = StoryCodePrefix.of(value2);
        ProjectAttribute attribute = ProjectAttribute.create(name, code, storyCodePrefix,
                Description.of("A"));
        Project project = Project.create(attribute);
        Project project1 = Project.create(project);
        Project project2 = Project.create(project1);
        Project project3 = Project.create(project2);
        Project createResult = Project.create(project3);
        Project other = null;

        // Act
        boolean actualSameValueAsResult = createResult.sameValueAs(other);

        // Assert
        boolean expectedSameValueAsResult = false;
        assertEquals(expectedSameValueAsResult, actualSameValueAsResult);
    }

    /**
     * Method under test: {@link Project#sameValueAs(Project)}
     */
    @Test
    void testSameValueAs2() {
        // Arrange
        String value = "42";
        ProjectName name = ProjectName.of(value);
        String value1 = "42";
        ProjectCode code = ProjectCode.of(value1);
        String value2 = "42";
        StoryCodePrefix storyCodePrefix = StoryCodePrefix.of(value2);
        ProjectAttribute attribute = ProjectAttribute.create(name, code, storyCodePrefix,
                Description.of("A"));
        Project project = Project.create(attribute);
        Project project1 = Project.create(project);
        Project project2 = Project.create(project1);
        Project project3 = Project.create(project2);
        Project createResult = Project.create(project3);
        String value3 = "42";
        ProjectName name1 = ProjectName.of(value3);
        String value4 = "42";
        ProjectCode code1 = ProjectCode.of(value4);
        String value5 = "42";
        StoryCodePrefix storyCodePrefix1 = StoryCodePrefix.of(value5);
        ProjectAttribute attribute1 = ProjectAttribute.create(name1, code1, storyCodePrefix1,
                Description.of("A"));
        Project other = Project.create(attribute1);

        // Act
        boolean actualSameValueAsResult = createResult.sameValueAs(other);

        // Assert
        boolean expectedSameValueAsResult = false;
        assertEquals(expectedSameValueAsResult, actualSameValueAsResult);
    }
}

