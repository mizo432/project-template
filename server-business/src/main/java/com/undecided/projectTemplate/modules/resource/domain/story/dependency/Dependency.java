package com.undecided.projectTemplate.modules.resource.domain.story.dependency;

import com.undecided.projectTemplate.modules.resource.domain.story.Story;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
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

    private final UlidIdentifier<Story> sourceStoryId;

    private final UlidIdentifier<Story> destStoryId;

    Dependency(UlidIdentifier<Dependency> dependencyId, AuditInfo auditInfo,
        UlidIdentifier<Story> sourceStoryId,
        UlidIdentifier<Story> destStoryId) {
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

    public static Dependency create(UlidIdentifier<Story> sourceStoryId,
        UlidIdentifier<Story> destStoryId) {
        return new Dependency(UlidIdentifier.newInstance(), AuditInfo.empty(), sourceStoryId,
            destStoryId);

    }

    public static Dependency reconstruct(String dependencyId, String sourceStoryId,
        String destStoryId) {
        return reconstruct(UlidIdentifier.reconstruct(dependencyId), AuditInfo.empty(),
            UlidIdentifier.reconstruct(sourceStoryId), UlidIdentifier.reconstruct(destStoryId));

    }

    private static Dependency reconstruct(UlidIdentifier<Dependency> dependencyId,
        AuditInfo auditInfo, UlidIdentifier<Story> sourceStoryId,
        UlidIdentifier<Story> destStoryId) {
        return new Dependency(dependencyId, auditInfo, sourceStoryId, destStoryId);

    }

}
