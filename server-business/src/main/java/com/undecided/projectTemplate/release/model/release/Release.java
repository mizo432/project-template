package com.undecided.projectTemplate.release.model.release;

import com.undecided.projectTemplate.release.model.release.attribute.ReleaseAttribute;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "create")
@ToString
@EqualsAndHashCode
public class Release {
    ReleaseAttribute attribute;
    SnowflakeId projectId;
    StoryIds storyIds;

}
