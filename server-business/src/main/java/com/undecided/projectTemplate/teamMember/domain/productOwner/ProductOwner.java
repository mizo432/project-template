package com.undecided.projectTemplate.teamMember.domain.productOwner;

import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import com.undecided.projectTemplate.teamMember.domain.member.MemberInitial;
import com.undecided.projectTemplate.teamMember.domain.member.MemberName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Id;

@Getter
@EqualsAndHashCode
@ToString
public class ProductOwner {

    @Id
    protected final SnowflakeId<ProductOwner> id;

    protected final AuditInfo auditInfo;

    private final MemberName name;
    private final MemberInitial initial;

    public ProductOwner(SnowflakeId<ProductOwner> id, AuditInfo auditInfo,
                        MemberName name, MemberInitial initial) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.name = name;
        this.initial = initial;
    }
}
