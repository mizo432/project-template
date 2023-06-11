package com.undecided.projectTemplate.story.domain.story.dependency;

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

    private final SnowflakeId sourceStoryId;

    private final SnowflakeId destStoryId;

    Dependency(
            SnowflakeId sourceStoryId,
            SnowflakeId destStoryId) {
        this.sourceStoryId = sourceStoryId;
        this.destStoryId = destStoryId;
    }

    public static Dependency create(SnowflakeId sourceStoryId,
                                    SnowflakeId destStoryId) {
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
            SnowflakeId sourceStoryId,
            SnowflakeId destStoryId) {
        return new Dependency(sourceStoryId, destStoryId);

    }

    public boolean sameValueAs(Dependency other) {
        return sourceStoryId.equals(other.sourceStoryId)
                && destStoryId.equals(other.destStoryId);

    }

}
