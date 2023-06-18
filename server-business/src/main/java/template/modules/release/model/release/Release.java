package template.modules.release.model.release;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import template.modules.release.model.release.attribute.ReleaseAttribute;
import template.shared.entity.id.SnowflakeId;

@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "create")
@ToString
@EqualsAndHashCode
public class Release {
    ReleaseAttribute attribute;
    SnowflakeId projectId;
    StoryIds storyIds;

}
