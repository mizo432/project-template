package com.undecided.projectTemplate.shared.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Embeddable;

@Getter
@EqualsAndHashCode
@ToString
@Embeddable
public class AuditInfo {

    private final WhenNoticed whenNoticed;
    private final WhoNoticed whoNoticed;

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
