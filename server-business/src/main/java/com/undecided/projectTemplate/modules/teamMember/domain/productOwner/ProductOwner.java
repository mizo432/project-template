package com.undecided.projectTemplate.modules.teamMember.domain.productOwner;

import com.undecided.projectTemplate.modules.teamMember.domain.member.MemberInitial;
import com.undecided.projectTemplate.modules.teamMember.domain.member.MemberName;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProductOwner extends AbstractEntity<ProductOwner> {

    private final MemberName name;
    private final MemberInitial initial;

    public ProductOwner(UlidIdentifier<ProductOwner> identifier, AuditInfo auditInfo,
        MemberName name, MemberInitial initial) {
        super(identifier, auditInfo);
        this.name = name;
        this.initial = initial;
    }
}
