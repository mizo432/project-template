package org.venusPj.projectTemplate.modules.resource.domain.story.dependency;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.modules.resource.domain.story.Story;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Dependency extends AbstractEntity<Dependency> {

    private final Identifier<Story> sourceStoryId;

    private final Identifier<Story> destStoryId;

    public Dependency(Identifier<Dependency> dependencyId, AuditInfo auditInfo,
        Identifier<Story> sourceStoryId,
        Identifier<Story> destStoryId) {
        super(dependencyId, auditInfo);
        this.sourceStoryId = sourceStoryId;
        this.destStoryId = destStoryId;
    }

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

}
