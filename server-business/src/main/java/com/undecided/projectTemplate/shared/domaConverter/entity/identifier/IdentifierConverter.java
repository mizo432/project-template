package com.undecided.projectTemplate.shared.domaConverter.entity.identifier;

import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class IdentifierConverter implements DomainConverter<UlidIdentifier<?>, String> {

    @Override
    public String fromDomainToValue(UlidIdentifier identifier) {
        return identifier.getValue();
    }

    @Override
    public UlidIdentifier fromValueToDomain(String value) {
        return UlidIdentifier.reconstruct(value);

    }
}
