package com.undecided.projectTemplate.shared.entity;

import static com.undecided.primitive.object.Objects2.isNull;

import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;
import java.util.Objects;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Id;

@Getter
@ToString
public abstract class AbstractEntity<E extends AbstractEntity<E>> {

    @Id
    protected final UildIdentifier<E> id;

    protected final AuditInfo auditInfo;

    protected AbstractEntity() {
        this(UildIdentifier.empty(), AuditInfo.empty());

    }

    protected AbstractEntity(UildIdentifier<E> id, AuditInfo auditInfo) {
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
        E that = (E) other;
        return sameIdentifierAs(that);

    }

    public boolean sameIdentifierAs(E other) {
        if (isNull(other)) {
            return false;
        }

        return id.equals(other.id);

    }

    protected boolean sameValueAs(E other) {
        if (this == other) {
            return true;
        }
        if (isNull(other)) {
            return false;
        }
        return sameIdentifierAs(other);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass(), id);

    }
}
