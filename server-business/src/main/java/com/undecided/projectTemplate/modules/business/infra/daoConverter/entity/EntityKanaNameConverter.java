package com.undecided.projectTemplate.modules.business.infra.daoConverter.entity;

import com.undecided.projectTemplate.modules.business.domain.entity.EntityKanaName;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class EntityKanaNameConverter implements DomainConverter<EntityKanaName, String> {

    @Override
    public String fromDomainToValue(EntityKanaName entityKanaName) {
        return entityKanaName.getValue();
    }

    @Override
    public EntityKanaName fromValueToDomain(String value) {
        return EntityKanaName.reconstruct(value);
        
    }
}
