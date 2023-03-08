package com.undecided.projectTemplate.modules.business.infra.daoConverter.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.undecided.projectTemplate.modules.business.domain.entity.EntityName;
import org.junit.jupiter.api.Test;

class EntityNameConverterTest {

    /**
     * Method under test: {@link EntityNameConverter#fromDomainToValue(EntityName)}
     */
    @Test
    void testFromDomainToValue() {
        EntityNameConverter entityNameConverter = new EntityNameConverter();
        assertEquals("42", entityNameConverter.fromDomainToValue(EntityName.of("42")));
    }


    /**
     * Method under test: {@link EntityNameConverter#fromValueToDomain(String)}
     */
    @Test
    void testFromValueToDomain() {
        assertEquals("42", (new EntityNameConverter()).fromValueToDomain("42").getValue());
    }
}

