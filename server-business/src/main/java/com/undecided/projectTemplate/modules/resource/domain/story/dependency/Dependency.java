package com.undecided.projectTemplate.modules.resource.domain.story.dependency;

import com.undecided.projectTemplate.modules.resource.domain.story.Story;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.Identifier;
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

    private final Identifier<Story> sourceStoryId;

    private final Identifier<Story> destStoryId;

    Dependency(Identifier<Dependency> dependencyId, AuditInfo auditInfo,
        Identifier<Story> sourceStoryId,
        Identifier<Story> destStoryId) {
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

    public static Dependency create(Identifier<Story> sourceStoryId,
        Identifier<Story> destStoryId) {
        return new Dependency(Identifier.newInstance(), AuditInfo.empty(), sourceStoryId,
            destStoryId);

    }

    public static Dependency reconstruct(String dependencyId, String sourceStoryId,
        String destStoryId) {
        return reconstruct(Identifier.reconstruct(dependencyId), AuditInfo.empty(),
            Identifier.reconstruct(sourceStoryId), Identifier.reconstruct(destStoryId));

    }

    private static Dependency reconstruct(Identifier<Dependency> dependencyId,
        AuditInfo auditInfo, Identifier<Story> sourceStoryId, Identifier<Story> destStoryId) {
        return new Dependency(dependencyId, auditInfo, sourceStoryId, destStoryId);

    }

}
