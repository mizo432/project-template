package com.undecided.projectTemplate.shared.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.undecided.gfw.common.exception.SystemException;
import com.undecided.projectTemplate.resource.domain.partyRole.user.User;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import com.undecided.projectTemplate.shared.value.ValuePreconditions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.VisibleForTesting;
import org.seasar.doma.Column;
import org.seasar.doma.Embeddable;

import java.time.LocalDateTime;

/**
 * 会計情報
 */
@Getter
@EqualsAndHashCode
@ToString
@Embeddable
public class AuditInfo {

    @Column(name = "created_at", insertable = false, updatable = false)
    private final WhenNoticed whenNoticed;
    @Column(name = "created_by", updatable = false)
    private WhoNoticed whoNoticed;

    public void setWhoNoticed(SnowflakeIdentifier<User> userId) {
        ValuePreconditions.checkNotEmpty(userId, () -> new SystemException("E0001001", "userIdが指定されていません"));
        whoNoticed = WhoNoticed.of(userId);
    }

    public AuditInfo() {
        this.whenNoticed = WhenNoticed.empty();
        this.whoNoticed = WhoNoticed.empty();
    }

    @VisibleForTesting
    public AuditInfo(WhenNoticed whenNoticed, WhoNoticed whoNoticed) {
        this.whenNoticed = whenNoticed;
        this.whoNoticed = whoNoticed;
    }

    public static AuditInfo reconstruct(LocalDateTime whenNoticed, Long whoNoticed) {
        return new AuditInfo(WhenNoticed.reconstruct(whenNoticed),
                WhoNoticed.reconstruct(whoNoticed));

    }

    public static AuditInfo of(Long whoNoticed) {
        return of(WhoNoticed.reconstruct(whoNoticed));

    }

    public static AuditInfo of(WhoNoticed whoNoticed) {
        return new AuditInfo(WhenNoticed.now(),
                whoNoticed);

    }

    public static AuditInfo empty() {
        return new AuditInfo(WhenNoticed.empty(), WhoNoticed.empty());
    }

    @JsonIgnore
    public boolean isEmpty() {
        return whenNoticed.isEmpty() && whoNoticed.isEmpty();
    }
}
