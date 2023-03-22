package com.undecided.projectTemplate.resource.domain.project.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.undecided.projectTemplate.resource.domain.story.attribute.Description;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.seasar.doma.Embeddable;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProjectAttribute implements Serializable {

    private ProjectName projectName;
    private ProjectCode projectCode;
    private StoryCodePrefix storyCodePrefix;
    private Description description;
    private static final ProjectAttribute EMPTY = new ProjectAttribute(ProjectName.empty(),
        ProjectCode.empty(), StoryCodePrefix.empty(), Description.empty());

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
