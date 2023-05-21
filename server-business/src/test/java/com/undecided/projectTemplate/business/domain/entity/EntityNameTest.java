package com.undecided.projectTemplate.business.domain.entity;

import com.undecided.projectTemplate.business.domain.model.entity.attribute.EntityName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityNameTest {

    /**
     * Method under test: {@link EntityName#of(String)}
     */
    @Test
    void testOf() {
        assertEquals("42", EntityName.of("42").getValue());
    }

    /**
     * Method under test: {@link EntityName#reconstruct(String)}
     */
    @Test
    void testReconstruct() {
        assertEquals("42", EntityName.reconstruct("42").getValue());
    }

    /**
     * Method under test: {@link EntityName#asString()}
     */
    @Test
    void testAsString() {
        assertEquals("42", EntityName.of("42").asString());
    }
}

