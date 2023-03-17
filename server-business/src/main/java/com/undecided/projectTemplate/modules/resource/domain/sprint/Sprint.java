package com.undecided.projectTemplate.modules.resource.domain.sprint;

import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Sprint extends AbstractEntity<Sprint> {

    protected Sprint(UildIdentifier<Sprint> id,
        AuditInfo auditInfo) {
        super(id, auditInfo);
    }
}
