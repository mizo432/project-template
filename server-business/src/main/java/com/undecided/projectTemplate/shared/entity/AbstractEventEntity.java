package com.undecided.projectTemplate.shared.entity;

import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;

public abstract class AbstractEventEntity<E extends AbstractEventEntity<E>> extends
    AbstractEntity<E> {

    protected final WhenOccurred whenOccurred;

    protected AbstractEventEntity(UildIdentifier<E> id, WhenOccurred whenOccurred,
        AuditInfo auditInfo) {
        super(id, auditInfo);
        this.whenOccurred = whenOccurred;

    }

}
