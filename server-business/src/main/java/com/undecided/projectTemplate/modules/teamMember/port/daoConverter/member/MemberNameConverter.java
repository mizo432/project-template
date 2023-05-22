package com.undecided.projectTemplate.modules.teamMember.port.daoConverter.member;

import com.undecided.projectTemplate.modules.teamMember.domain.member.MemberName;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class MemberNameConverter implements DomainConverter<MemberName, String> {

    @Override
    public String fromDomainToValue(MemberName entity) {
        return entity.getValue();
    }

    @Override
    public MemberName fromValueToDomain(String value) {
        return MemberName.reconstruct(value);

    }
}
