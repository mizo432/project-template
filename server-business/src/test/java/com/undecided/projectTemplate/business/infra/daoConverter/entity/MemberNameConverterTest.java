package com.undecided.projectTemplate.business.infra.daoConverter.entity;

import com.undecided.projectTemplate.business.domain.entity.EntityKanaName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

