package org.venusPj.projectTemplate.modules.resource.domain.project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class AbstractProjectResource<E extends AbstractProjectResource<E>> extends
    AbstractEntity<E> {

    private final Identifier<Project> projectId;


    protected AbstractProjectResource(Identifier<E> id,
        AuditInfo auditInfo,
        Identifier<Project> projectId) {
        super(id, auditInfo);
        this.projectId = projectId;
    }

    @Override
    protected boolean sameValueAs(E other) {
        return super.sameValueAs(other) &&
            projectId.equals(other.getProjectId());
    }
}