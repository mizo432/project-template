package com.undecided.projectTemplate.resource.domain.project.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.undecided.projectTemplate.resource.domain.story.attribute.Description;
import lombok.Getter;
import org.seasar.doma.Embeddable;

import java.io.Serializable;

@Getter
@Embeddable
public class ProjectAttribute implements Serializable {

    private final ProjectName projectName;
    private final ProjectCode projectCode;
    private final StoryCodePrefix storyCodePrefix;
    private final Description description;
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
            @JsonProperty("projectCode") ProjectCode projectCode,
            @JsonProperty("storyCodePrefix") StoryCodePrefix storyCodePrefix,
            @JsonProperty("description") Description description) {
        return new ProjectAttribute(projectName, projectCode, storyCodePrefix, description);
    }

    public static ProjectAttribute empty() {
        return EMPTY;
    }
}
