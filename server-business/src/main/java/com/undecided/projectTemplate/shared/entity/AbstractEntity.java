package com.undecided.projectTemplate.shared.entity;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Id;

import java.util.Objects;

import static com.undecided.primitive.object.Objects2.isNull;

@Getter
@ToString
public abstract class AbstractEntity<E extends AbstractEntity<E>> implements Entity<E> {

    @Id
    protected final SnowflakeIdentifier<E> id;

    protected final AuditInfo auditInfo;

    protected AbstractEntity() {
        this(SnowflakeIdentifier.empty(), AuditInfo.empty());

    }

    protected AbstractEntity(SnowflakeIdentifier<E> id, AuditInfo auditInfo) {
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

    /**
     * IDが一致しているjかを判定します。
     *
     * @param other 判定対象オブジェクト
     * @return 一致している場合はtrueを返却します。
     */
    public boolean sameIdentifierAs(E other) {
        if (isNull(other)) {
            return false;
        }

        return id.equals(other.id);

    }

    /**
     * 管理しているフィールドが一致しているかを判定します。
     * <ore>
     * 会計情報については比較の対象フィールドにしません。
     * </ore>
     *
     * @param other 判定対象オブジェクト
     * @return 一致している場合はtrueを返却します。
     */
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
