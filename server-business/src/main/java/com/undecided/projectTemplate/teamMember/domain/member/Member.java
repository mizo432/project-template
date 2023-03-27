package com.undecided.projectTemplate.teamMember.domain.member;

import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Member extends AbstractEntity<Member> {

    private final MemberName name;
    private final MemberInitial initial;

    public Member(SnowflakeIdentifier<Member> identifier, AuditInfo auditInfo, MemberName name,
                  MemberInitial initial) {
        super(identifier, auditInfo);
        this.name = name;
        this.initial = initial;
    }

}
