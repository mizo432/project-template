package org.venusPj.projectTemplate.modules.resource.domain.story.dependency;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.modules.resource.domain.story.StoryId;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Dependency extends AbstractEntity<DependencyId, Dependency> {

    private final StoryId sourceStoryId;

    private final StoryId destStoryId;

    public Dependency(DependencyId dependencyId, AuditInfo auditInfo, StoryId sourceStoryId,
        StoryId destStoryId) {
        super(dependencyId, auditInfo);
        this.sourceStoryId = sourceStoryId;
        this.destStoryId = destStoryId;
    }

    public boolean sameValueAs(Dependency other) {
        return super.sameValueAs(other)
            && sourceStoryId.equals(other.sourceStoryId)
            && destStoryId.equals(other.destStoryId);

    }

    public static Dependency create(StoryId sourceStoryId, StoryId destStoryId) {
        return new Dependency(DependencyId.newInstance(), AuditInfo.empty(), sourceStoryId,
            destStoryId);

    }

}
