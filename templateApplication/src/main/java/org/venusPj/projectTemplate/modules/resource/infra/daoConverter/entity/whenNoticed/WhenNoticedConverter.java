package org.venusPj.projectTemplate.modules.resource.infra.daoConverter.entity.whenNoticed;

import java.time.LocalDateTime;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;
import org.venusPj.projectTemplate.shared.entity.WhenNoticed;

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
