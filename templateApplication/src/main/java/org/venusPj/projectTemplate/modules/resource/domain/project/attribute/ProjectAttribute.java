package org.venusPj.projectTemplate.modules.resource.domain.project.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Embeddable;
import org.venusPj.projectTemplate.modules.resource.domain.story.attribute.Description;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Embeddable
public class ProjectAttribute implements Serializable {

    private static final ProjectAttribute EMPTY = new ProjectAttribute(ProjectName.empty(),
        ProjectCode.empty(), StoryCodePrefix.empty(), Description.empty());

    private final ProjectName projectName;
    private final ProjectCode projectCode;
    private final StoryCodePrefix storyCodePrefix;

    private final Description description;

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
