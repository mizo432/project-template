package org.venusPj.projectTemplate.shared.entity;

import java.util.Objects;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Getter
@ToString
public abstract class AbstractEntity<E extends AbstractEntity<E>> {

    protected final Identifier<E> id;

    protected final AuditInfo auditInfo;

    protected AbstractEntity() {
        this(Identifier.empty(), AuditInfo.empty());
    }

    protected AbstractEntity(Identifier<E> id, AuditInfo auditInfo) {
        this.id = id;
        this.auditInfo = auditInfo;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (other instanceof AbstractEntity<?>) {
            AbstractEntity<E> that = (AbstractEntity<E>) other;
            return id.equals(that.id);
        }
        return false;
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
        return Objects.hash(id);

    }
}
