package com.undecided.projectTemplate.shared.domaConverter.entity.identifier;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class SnowflakeIdentifierConverter implements DomainConverter<SnowflakeId, Long> {

    @Override
    public Long fromDomainToValue(SnowflakeId identifier) {
        return identifier.getValue();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public SnowflakeId fromValueToDomain(Long value) {
        return SnowflakeId.reconstruct(value);

    }
}
