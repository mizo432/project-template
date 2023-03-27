package com.undecided.projectTemplate.resource.domain.story.dependency;

import com.undecided.projectTemplate.resource.domain.story.Story;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 依存ストーリー
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Dependency extends AbstractEntity<Dependency> {

    private final SnowflakeIdentifier<Story> sourceStoryId;

    private final SnowflakeIdentifier<Story> destStoryId;

    Dependency(SnowflakeIdentifier<Dependency> dependencyId, AuditInfo auditInfo,
               SnowflakeIdentifier<Story> sourceStoryId,
               SnowflakeIdentifier<Story> destStoryId) {
        super(dependencyId, auditInfo);
        this.sourceStoryId = sourceStoryId;
        this.destStoryId = destStoryId;
    }

    @Override
    public boolean sameValueAs(Dependency other) {
        return super.sameValueAs(other)
                && sourceStoryId.equals(other.sourceStoryId)
                && destStoryId.equals(other.destStoryId);

    }

    public static Dependency create(SnowflakeIdentifier<Story> sourceStoryId,
                                    SnowflakeIdentifier<Story> destStoryId) {
        return new Dependency(SnowflakeIdentifier.newInstance(), AuditInfo.empty(), sourceStoryId,
                destStoryId);

    }

    public static Dependency reconstruct(Long dependencyId, Long sourceStoryId,
                                         Long destStoryId) {
        return reconstruct(SnowflakeIdentifier.reconstruct(dependencyId), AuditInfo.empty(),
                SnowflakeIdentifier.reconstruct(sourceStoryId), SnowflakeIdentifier.reconstruct(destStoryId));

    }

    private static Dependency reconstruct(SnowflakeIdentifier<Dependency> dependencyId,
                                          AuditInfo auditInfo, SnowflakeIdentifier<Story> sourceStoryId,
                                          SnowflakeIdentifier<Story> destStoryId) {
        return new Dependency(dependencyId, auditInfo, sourceStoryId, destStoryId);

    }

}
