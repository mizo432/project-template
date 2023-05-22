package com.undecided.projectTemplate.sprint.domain.sprint;

import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Id;

@Getter
@EqualsAndHashCode
@ToString
public class Sprint {

    @Id
    protected final SnowflakeId<Sprint> id;

    protected final AuditInfo auditInfo;

    protected Sprint(SnowflakeId<Sprint> id,
                     AuditInfo auditInfo) {
        this.id = id;
        this.auditInfo = auditInfo;
    }
}
