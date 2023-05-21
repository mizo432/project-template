package com.undecided.projectTemplate.story.domain.story.dependency;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import com.undecided.projectTemplate.story.domain.story.Story;
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

    private final SnowflakeIdentifier<Story> sourceStoryId;

    private final SnowflakeIdentifier<Story> destStoryId;

    Dependency(
            SnowflakeIdentifier<Story> sourceStoryId,
            SnowflakeIdentifier<Story> destStoryId) {
        this.sourceStoryId = sourceStoryId;
        this.destStoryId = destStoryId;
    }

    public static Dependency create(SnowflakeIdentifier<Story> sourceStoryId,
                                    SnowflakeIdentifier<Story> destStoryId) {
        return new Dependency(sourceStoryId,
                destStoryId);

    }

    public static Dependency reconstruct(Long sourceStoryId,
                                         Long destStoryId) {
        return reconstruct(
                SnowflakeIdentifier.reconstruct(sourceStoryId),
                SnowflakeIdentifier.reconstruct(destStoryId));

    }

    private static Dependency reconstruct(
            SnowflakeIdentifier<Story> sourceStoryId,
            SnowflakeIdentifier<Story> destStoryId) {
        return new Dependency(sourceStoryId, destStoryId);

    }

    public boolean sameValueAs(Dependency other) {
        return sourceStoryId.equals(other.sourceStoryId)
                && destStoryId.equals(other.destStoryId);

    }

}
