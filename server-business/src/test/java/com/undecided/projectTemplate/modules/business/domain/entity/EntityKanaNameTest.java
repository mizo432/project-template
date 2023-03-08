package com.undecided.projectTemplate.modules.business.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EntityKanaNameTest {

    /**
     * Method under test: {@link EntityKanaName#of(String)}
     */
    @Test
    void testOf() {
        assertEquals("42", EntityKanaName.of("42").getValue());
    }

    /**
     * Method under test: {@link EntityKanaName#reconstruct(String)}
     */
    @Test
    void testReconstruct() {
        assertEquals("42", EntityKanaName.reconstruct("42").getValue());
    }

    /**
     * Method under test: {@link EntityKanaName#asString()}
     */
    @Test
    void testAsString() {
        assertEquals("42", EntityKanaName.of("42").asString());
    }
}

