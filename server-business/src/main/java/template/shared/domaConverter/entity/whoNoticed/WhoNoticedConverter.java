package template.shared.domaConverter.entity.whoNoticed;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import template.shared.entity.WhoNoticed;

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
