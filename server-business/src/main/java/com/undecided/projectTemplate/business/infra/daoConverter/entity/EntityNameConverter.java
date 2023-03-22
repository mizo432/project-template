package com.undecided.projectTemplate.business.infra.daoConverter.entity;

import com.undecided.projectTemplate.business.domain.entity.EntityName;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class EntityNameConverter implements DomainConverter<EntityName, String> {

    @Override
    public String fromDomainToValue(EntityName entityName) {
        return entityName.getValue();
    }

    @Override
    public EntityName fromValueToDomain(String value) {
        return EntityName.reconstruct(value);
    }
}
