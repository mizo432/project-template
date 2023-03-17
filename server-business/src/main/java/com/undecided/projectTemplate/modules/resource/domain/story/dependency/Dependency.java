package com.undecided.projectTemplate.modules.resource.domain.story.dependency;

import com.undecided.projectTemplate.modules.resource.domain.story.Story;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;
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

    private final UildIdentifier<Story> sourceStoryId;

    private final UildIdentifier<Story> destStoryId;

    Dependency(UildIdentifier<Dependency> dependencyId, AuditInfo auditInfo,
        UildIdentifier<Story> sourceStoryId,
        UildIdentifier<Story> destStoryId) {
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

    public static Dependency create(UildIdentifier<Story> sourceStoryId,
        UildIdentifier<Story> destStoryId) {
        return new Dependency(UildIdentifier.newInstance(), AuditInfo.empty(), sourceStoryId,
            destStoryId);

    }

    public static Dependency reconstruct(String dependencyId, String sourceStoryId,
        String destStoryId) {
        return reconstruct(UildIdentifier.reconstruct(dependencyId), AuditInfo.empty(),
            UildIdentifier.reconstruct(sourceStoryId), UildIdentifier.reconstruct(destStoryId));

    }

    private static Dependency reconstruct(UildIdentifier<Dependency> dependencyId,
        AuditInfo auditInfo, UildIdentifier<Story> sourceStoryId,
        UildIdentifier<Story> destStoryId) {
        return new Dependency(dependencyId, auditInfo, sourceStoryId, destStoryId);

    }

}
