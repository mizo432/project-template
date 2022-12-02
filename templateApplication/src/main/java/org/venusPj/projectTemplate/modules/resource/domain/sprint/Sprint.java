package org.venusPj.projectTemplate.modules.resource.domain.sprint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Sprint extends AbstractEntity<Sprint> {

    protected Sprint(Identifier<Sprint> id,
        AuditInfo auditInfo) {
        super(id, auditInfo);
    }
}
