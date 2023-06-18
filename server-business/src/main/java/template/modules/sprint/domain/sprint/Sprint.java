package template.modules.sprint.domain.sprint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Id;
import template.shared.entity.AuditInfo;
import template.shared.entity.id.SnowflakeId;

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
