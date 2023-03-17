package com.undecided.projectTemplate.shared.domaConverter.entity.identifier;

import com.undecided.projectTemplate.shared.entity.id.UildIdentifier;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class IdentifierConverter implements DomainConverter<UildIdentifier<?>, String> {

    @Override
    public String fromDomainToValue(UildIdentifier identifier) {
        return identifier.getValue();
    }

    @Override
    public UildIdentifier fromValueToDomain(String value) {
        return UildIdentifier.reconstruct(value);

    }
}
