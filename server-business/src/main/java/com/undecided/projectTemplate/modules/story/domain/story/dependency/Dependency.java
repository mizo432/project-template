package com.undecided.projectTemplate.modules.story.domain.story.dependency;

import com.undecided.projectTemplate.modules.story.domain.story.Story;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 依存ストーリー
 */
@Getter
@EqualsAndHashCode
@ToString
public class Dependency {

    private final SnowflakeId<Story> sourceStoryId;

    private final SnowflakeId<Story> destStoryId;

    Dependency(
            SnowflakeId<Story> sourceStoryId,
            SnowflakeId<Story> destStoryId) {
        this.sourceStoryId = sourceStoryId;
        this.destStoryId = destStoryId;
    }

    public static Dependency create(SnowflakeId<Story> sourceStoryId,
                                    SnowflakeId<Story> destStoryId) {
        return new Dependency(sourceStoryId,
                destStoryId);

    }

    public static Dependency reconstruct(Long sourceStoryId,
                                         Long destStoryId) {
        return reconstruct(
                SnowflakeId.reconstruct(sourceStoryId),
                SnowflakeId.reconstruct(destStoryId));

    }

    private static Dependency reconstruct(
            SnowflakeId<Story> sourceStoryId,
            SnowflakeId<Story> destStoryId) {
        return new Dependency(sourceStoryId, destStoryId);

    }

    public boolean sameValueAs(Dependency other) {
        return sourceStoryId.equals(other.sourceStoryId)
                && destStoryId.equals(other.destStoryId);

    }

}
