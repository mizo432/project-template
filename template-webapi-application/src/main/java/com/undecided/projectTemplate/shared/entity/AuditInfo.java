package com.undecided.projectTemplate.shared.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Embeddable;

@Getter
@AllArgsConstructor
@lombok.EqualsAndHashCode
@ToString
@Embeddable
public class AuditInfo {

    private final WhenNoticed whenNoticed;
    private final WhoNoticed whoNoticed;

    public static AuditInfo reconstruct(LocalDateTime whenNoticed, String whoNoticed) {
        return new AuditInfo(WhenNoticed.reconstruct(whenNoticed),
            WhoNoticed.reconstruct(whoNoticed));

    }

    public static AuditInfo of(String whoNoticed) {
        return of(WhoNoticed.reconstruct(whoNoticed));

    }

    public static AuditInfo of(WhoNoticed whoNoticed) {
        return new AuditInfo(WhenNoticed.now(),
            whoNoticed);

    }

    public static AuditInfo empty() {
        return new AuditInfo(WhenNoticed.empty(), WhoNoticed.empty());
    }
}
