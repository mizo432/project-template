package com.lissajous.taxiDispatcher.shared.entity;

import com.lissajous.taxiDispatcher.shared.entity.id.Id;
import java.util.Objects;

public abstract class AbstractEntity<I extends Id<I>, E extends AbstractEntity<I, E>> {

    protected final I id;

    protected final AuditInfo auditInfo;

    protected AbstractEntity(I id, AuditInfo auditInfo) {
        this.id = id;
        this.auditInfo = auditInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractEntity<?, ?> that = (AbstractEntity<?, ?>) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass().getCanonicalName(), id);
    }
}
