package com.undecided.projectTemplate.resource.domain.project.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.undecided.projectTemplate.resource.domain.story.attribute.Description;
import java.io.Serializable;
import lombok.Getter;
import org.seasar.doma.Embeddable;

@Getter
@Embeddable
public class ProjectAttribute implements Serializable {

    private ProjectName projectName;
    private ProjectCode projectCode;
    private StoryCodePrefix storyCodePrefix;
    private Description description;
    private static final ProjectAttribute EMPTY = new ProjectAttribute(ProjectName.empty(),
        ProjectCode.empty(), StoryCodePrefix.empty(), Description.empty());

    public ProjectAttribute(ProjectName projectName, ProjectCode projectCode,
        StoryCodePrefix storyCodePrefix, Description description) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.storyCodePrefix = storyCodePrefix;
        this.description = description;
    }

    @JsonCreator
    public static ProjectAttribute create(
        @JsonProperty("projectName") final ProjectName projectName,
        @JsonProperty("projectName") ProjectCode projectCode,
        @JsonProperty("storyCodePrefix") StoryCodePrefix storyCodePrefix,
        @JsonProperty("description") Description description) {
        return new ProjectAttribute(projectName, projectCode, storyCodePrefix, description);
    }

    public static ProjectAttribute empty() {
        return EMPTY;
    }
}
