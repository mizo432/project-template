package template.shared.doma.converter.entity.whenNoticed;

import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import template.shared.entity.WhenNoticed;

import java.time.LocalDateTime;

@ExternalDomain
public class WhenNoticedConverter implements DomainConverter<WhenNoticed, LocalDateTime> {

    @Override
    public LocalDateTime fromDomainToValue(WhenNoticed whenNoticed) {
        return whenNoticed.getValue();
    }

    @Override
    public WhenNoticed fromValueToDomain(LocalDateTime value) {
        return WhenNoticed.reconstruct(value);

    }
}
