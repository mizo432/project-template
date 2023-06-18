package template.modules.project.domain.model.project.attribute;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.seasar.doma.Column;
import org.seasar.doma.Embeddable;
import template.shared.type.description.Description;

import java.io.Serializable;

@Getter
@Embeddable
public class ProjectAttribute implements Serializable {

    @Column(name = "project_name")
    private final ProjectName projectName;
    @Column(name = "project_code")
    private final ProjectCode projectCode;
    @Column(name = "story_code_prefix")
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

    @Override
    public String toString() {
        return "ProjectAttribute{" +
                "projectName=" + projectName +
                ", projectCode=" + projectCode +
                ", storyCodePrefix=" + storyCodePrefix +
                ", description=" + description +
                '}';
    }
}
