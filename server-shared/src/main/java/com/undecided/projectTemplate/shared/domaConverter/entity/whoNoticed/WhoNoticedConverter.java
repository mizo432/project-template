package com.undecided.projectTemplate.shared.domaConverter.entity.whoNoticed;

import com.undecided.projectTemplate.shared.entity.WhoNoticed;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class WhoNoticedConverter implements DomainConverter<WhoNoticed, Long> {

    @Override
    public Long fromDomainToValue(WhoNoticed whoNoticed) {
        return whoNoticed.getValue();
    }

    @Override
    public WhoNoticed fromValueToDomain(Long value) {
        return WhoNoticed.reconstruct(value);

    }
}
