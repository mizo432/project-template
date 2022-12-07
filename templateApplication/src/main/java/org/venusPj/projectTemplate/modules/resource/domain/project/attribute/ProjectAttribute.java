package org.venusPj.projectTemplate.modules.resource.domain.project.attribute;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Embeddable;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Embeddable
public class ProjectAttribute {

    private static final ProjectAttribute EMPTY = new ProjectAttribute(ProjectName.empty(),
        ProjectCode.empty(), StoryCodePrefix.empty());

    private final ProjectName name;
    private final ProjectCode code;
    private final StoryCodePrefix storyCodePrefix;

    public static ProjectAttribute create(ProjectName name, ProjectCode code,
        StoryCodePrefix storyCodePrefix) {
        return new ProjectAttribute(name, code, storyCodePrefix);
    }

    public static ProjectAttribute empty() {
        return EMPTY;
    }
}
