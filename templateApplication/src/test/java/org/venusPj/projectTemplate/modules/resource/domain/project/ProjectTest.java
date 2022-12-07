package org.venusPj.projectTemplate.modules.resource.domain.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectAttribute;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectCode;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.ProjectName;
import org.venusPj.projectTemplate.modules.resource.domain.project.attribute.StoryCodePrefix;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.WhenNoticed;
import org.venusPj.projectTemplate.shared.entity.WhoNoticed;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

class ProjectTest {

    /**
     * Method under test: {@link Project#Project(Identifier, AuditInfo, ProjectAttribute)}
     */
    @Test
    void testConstructor() {
        // Arrange
        Identifier<Project> newInstanceResult = Identifier.newInstance();
        AuditInfo emptyResult = AuditInfo.empty();
        String value = "42";
        ProjectName ofResult = ProjectName.of(value);
        String value1 = "42";
        ProjectCode ofResult1 = ProjectCode.of(value1);
        String value2 = "42";
        StoryCodePrefix ofResult2 = StoryCodePrefix.of(value2);
        ProjectAttribute createResult = ProjectAttribute.create(ofResult, ofResult1, ofResult2);

        // Act
        Project actualProject = new Project(newInstanceResult, emptyResult, createResult);

        System.out.println(actualProject);

        // Assert
        ProjectAttribute attribute = actualProject.getAttribute();
        assertSame(createResult, attribute);
        Identifier<Project> actualId = actualProject.getId();
        assertSame(newInstanceResult, actualId);
        AuditInfo auditInfo = actualProject.getAuditInfo();
        assertSame(emptyResult, auditInfo);
        StoryCodePrefix storyCodePrefix = attribute.getStoryCodePrefix();
        assertSame(ofResult2, storyCodePrefix);
        ProjectName name = attribute.getName();
        assertSame(ofResult, name);
        ProjectCode code = attribute.getCode();
        assertSame(ofResult1, code);
        String expectedValue = "42";
        String actualValue = name.getValue();
        assertEquals(expectedValue, actualValue);
        String expectedValue1 = "42";
        String actualValue1 = code.getValue();
        assertEquals(expectedValue1, actualValue1);
        String expectedValue2 = null;
        WhoNoticed whoNoticed = auditInfo.getWhoNoticed();
        String actualValue2 = whoNoticed.getValue();
        assertEquals(expectedValue2, actualValue2);
        String expectedValue3 = "42";
        String actualValue3 = storyCodePrefix.getValue();
        assertEquals(expectedValue3, actualValue3);
        LocalDateTime expectedValue4 = null;
        WhenNoticed whenNoticed = auditInfo.getWhenNoticed();
        LocalDateTime actualValue4 = whenNoticed.getValue();
        assertEquals(expectedValue4, actualValue4);
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
        ProjectAttribute createResult = ProjectAttribute.create(name, code, storyCodePrefix);
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
        ProjectAttribute createResult = ProjectAttribute.create(name, code, storyCodePrefix);

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
        ProjectAttribute attribute = ProjectAttribute.create(name, code, storyCodePrefix);
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
        ProjectAttribute attribute = ProjectAttribute.create(name, code, storyCodePrefix);
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
        ProjectAttribute attribute1 = ProjectAttribute.create(name1, code1, storyCodePrefix1);
        Project other = Project.create(attribute1);

        // Act
        boolean actualSameValueAsResult = createResult.sameValueAs(other);

        // Assert
        boolean expectedSameValueAsResult = false;
        assertEquals(expectedSameValueAsResult, actualSameValueAsResult);
    }
}

