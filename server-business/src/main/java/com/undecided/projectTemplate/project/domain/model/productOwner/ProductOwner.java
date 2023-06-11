package com.undecided.projectTemplate.project.domain.model.productOwner;

import com.undecided.projectTemplate.project.domain.model.member.MemberInitial;
import com.undecided.projectTemplate.project.domain.model.member.MemberName;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Id;

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
