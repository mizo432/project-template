package template.modules.project.domain.model.productOwner;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Id;
import template.modules.project.domain.model.member.MemberInitial;
import template.modules.project.domain.model.member.MemberName;
import template.shared.entity.AuditInfo;
import template.shared.entity.id.SnowflakeId;

@Getter
@EqualsAndHashCode
@ToString
public class ProductOwner {

    @Id
    protected final SnowflakeId id;

    protected final AuditInfo auditInfo;

    private final MemberName name;
    private final MemberInitial initial;

    public ProductOwner(SnowflakeId id, AuditInfo auditInfo,
                        MemberName name, MemberInitial initial) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.name = name;
        this.initial = initial;
    }
}
