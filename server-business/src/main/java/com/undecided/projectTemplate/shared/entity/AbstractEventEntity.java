package com.undecided.projectTemplate.shared.entity;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;

public abstract class AbstractEventEntity<E extends AbstractEventEntity<E>> extends
        AbstractEntity<E> implements Entity<E> {

    /**
     * いつ有効になるかを保持します
     * <pre>
     * 通常は現在が設定れています。
     * </pre>
     */
    protected final WhenOccurred whenOccurred;

    protected AbstractEventEntity(SnowflakeIdentifier<E> id, WhenOccurred whenOccurred,
                                  AuditInfo auditInfo) {
        super(id, auditInfo);
        this.whenOccurred = whenOccurred;

    }

}
