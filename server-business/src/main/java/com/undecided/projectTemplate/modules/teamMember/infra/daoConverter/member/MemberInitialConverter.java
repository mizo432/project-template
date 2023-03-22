package com.undecided.projectTemplate.modules.teamMember.infra.daoConverter.member;

import com.undecided.projectTemplate.modules.teamMember.domain.member.MemberInitial;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class MemberInitialConverter implements DomainConverter<MemberInitial, String> {

    @Override
    public String fromDomainToValue(MemberInitial entity) {
        return entity.getValue();
    }

    @Override
    public MemberInitial fromValueToDomain(String value) {
        return MemberInitial.reconstruct(value);

    }
}
