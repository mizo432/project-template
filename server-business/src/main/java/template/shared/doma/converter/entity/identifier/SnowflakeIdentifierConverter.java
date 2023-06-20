package template.shared.doma.converter.entity.identifier;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import template.shared.entity.id.SnowflakeId;

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
