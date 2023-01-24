package com.undecided.projectTemplate.shared.domaConverter.entity.identifier;

import com.undecided.projectTemplate.shared.entity.id.Identifier;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class IdentifierConverter implements DomainConverter<Identifier<?>, String> {

    @Override
    public String fromDomainToValue(Identifier identifier) {
        return identifier.getValue();
    }

    @Override
    public Identifier fromValueToDomain(String value) {
        return Identifier.reconstruct(value);

    }
}
