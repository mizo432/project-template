package com.undecided.projectTemplate.modules.sprint.domain.sprint;

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
    protected final SnowflakeId id;

    protected final AuditInfo auditInfo;

    protected Sprint(SnowflakeId id,
                     AuditInfo auditInfo) {
        this.id = id;
        this.auditInfo = auditInfo;
    }
}
