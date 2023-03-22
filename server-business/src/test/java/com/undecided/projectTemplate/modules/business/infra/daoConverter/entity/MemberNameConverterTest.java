package com.undecided.projectTemplate.modules.business.infra.daoConverter.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.undecided.projectTemplate.modules.business.domain.entity.EntityKanaName;
import org.junit.jupiter.api.Test;

class MemberNameConverterTest {

    /**
     * Method under test: {@link EntityKanaNameConverter#fromDomainToValue(EntityKanaName)}
     */
    @Test
    void testFromDomainToValue() {
        EntityKanaNameConverter entityKanaNameConverter = new EntityKanaNameConverter();
        assertEquals("42", entityKanaNameConverter.fromDomainToValue(EntityKanaName.of("42")));
    }

    /**
     * Method under test: {@link EntityKanaNameConverter#fromValueToDomain(String)}
     */
    @Test
    void testFromValueToDomain() {
        assertEquals("42", (new EntityKanaNameConverter()).fromValueToDomain("42").getValue());
    }
}

