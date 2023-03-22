package com.undecided.projectTemplate.modules.resource.domain.project;

import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class AbstractProjectResource<E extends AbstractProjectResource<E>> extends
    AbstractEntity<E> {

    private final UlidIdentifier<Project> projectId;


    protected AbstractProjectResource(UlidIdentifier<E> id,
        AuditInfo auditInfo,
        UlidIdentifier<Project> projectId) {
        super(id, auditInfo);
        this.projectId = projectId;
    }

    @Override
    protected boolean sameValueAs(E other) {
        return super.sameValueAs(other) &&
            projectId.equals(other.getProjectId());
    }
}
