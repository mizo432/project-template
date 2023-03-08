package com.undecided.projectTemplate.modules.business.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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

