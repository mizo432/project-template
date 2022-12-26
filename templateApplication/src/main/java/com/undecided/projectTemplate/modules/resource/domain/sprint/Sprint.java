package com.undecided.projectTemplate.modules.resource.domain.sprint;

import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import com.undecided.projectTemplate.shared.entity.id.Identifier;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Sprint extends AbstractEntity<Sprint> {

    protected Sprint(Identifier<Sprint> id,
        AuditInfo auditInfo) {
        super(id, auditInfo);
    }
}
