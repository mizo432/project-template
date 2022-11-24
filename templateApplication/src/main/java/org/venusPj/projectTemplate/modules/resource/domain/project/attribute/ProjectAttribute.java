package org.venusPj.projectTemplate.modules.resource.domain.project.attribute;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ProjectAttribute {

    private final ProjectName name;
    private final ProjectCode code;
    private final StoryCodePrefix storyCodePrefix;

    public static ProjectAttribute create(ProjectName name, ProjectCode code,
        StoryCodePrefix storyCodePrefix) {
        return new ProjectAttribute(name, code, storyCodePrefix);
    }
}
