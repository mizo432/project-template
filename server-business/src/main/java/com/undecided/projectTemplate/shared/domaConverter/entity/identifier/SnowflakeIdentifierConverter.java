package com.undecided.projectTemplate.shared.domaConverter.entity.identifier;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class SnowflakeIdentifierConverter implements DomainConverter<SnowflakeIdentifier<?>, Long> {

    @Override
    public Long fromDomainToValue(SnowflakeIdentifier<?> identifier) {
        return identifier.getValue();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public SnowflakeIdentifier fromValueToDomain(Long value) {
        return SnowflakeIdentifier.reconstruct(value);

    }
}
