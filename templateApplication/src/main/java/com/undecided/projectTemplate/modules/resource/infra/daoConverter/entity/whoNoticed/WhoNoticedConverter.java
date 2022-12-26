package com.undecided.projectTemplate.modules.resource.infra.daoConverter.entity.whoNoticed;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import com.undecided.projectTemplate.shared.entity.WhoNoticed;

@ExternalDomain
public class WhoNoticedConverter implements DomainConverter<WhoNoticed, String> {

    @Override
    public String fromDomainToValue(WhoNoticed whoNoticed) {
        return whoNoticed.getValue();
    }

    @Override
    public WhoNoticed fromValueToDomain(String value) {
        return WhoNoticed.reconstruct(value);
    }
}
