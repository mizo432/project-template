package org.venusPj.projectTemplate.modules.resource.domain.project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.id.Id;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class ProjectResource<I extends Id<I>, E extends ProjectResource<I, E>> extends
    AbstractEntity<I, E> {

    private final ProjectId projectId;


    protected ProjectResource(I id, AuditInfo auditInfo, ProjectId projectId) {
        super(id, auditInfo);
        this.projectId = projectId;
    }

    @Override
    protected boolean sameValueAs(E other) {
        return super.sameValueAs(other) &&
            projectId.equals(other.getProjectId());
    }
}
