package org.venusPj.projectTemplate.shared.entity;

import org.venusPj.projectTemplate.shared.entity.id.Id;

public abstract class AbstractEventEntity<I extends Id<I>, E extends AbstractEventEntity<I, E>> extends
    AbstractEntity<I, E> {

    protected final WhenOccurred whenOccurred;


    protected AbstractEventEntity(I id, WhenOccurred whenOccurred, AuditInfo auditInfo) {
        super(id, auditInfo);
        this.whenOccurred = whenOccurred;

    }

}
