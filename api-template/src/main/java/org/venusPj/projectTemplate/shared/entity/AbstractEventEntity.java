package com.lissajous.taxiDispatcher.shared.entity;

import com.lissajous.taxiDispatcher.shared.entity.id.Id;

public abstract class AbstractEventEntity<I extends Id<I>, E extends AbstractEventEntity<I, E>> extends
    AbstractEntity<I, E> {

    protected final OccuredAt occuredAt;


    protected AbstractEventEntity(I id, OccuredAt occuredAt, AuditInfo auditInfo) {
        super(id, auditInfo);
        this.occuredAt = occuredAt;

    }

}
