package org.venusPj.projectTemplate.shared.entity;

import java.util.Objects;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.id.Id;

@Getter
@ToString
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

    public boolean sameIdAs(E other) {
        return equals(other);
    }

    protected boolean sameValueAs(E other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return id.equals(other.id)
            && auditInfo.equals(other.auditInfo);


    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass().getCanonicalName(), id);
    }
}
