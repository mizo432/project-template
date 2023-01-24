package com.undecided.projectTemplate.shared.domaConverter.entity.whenNoticed;

import com.undecided.projectTemplate.shared.entity.WhenNoticed;
import java.time.LocalDateTime;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

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
