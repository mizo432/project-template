package com.undecided.projectTemplate.teamMember.domain.member;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MemberNameTest {

    /**
     * Method under test: {@link MemberName#getValue()}
     */
    @Test
    void testGetValue() {
        assertEquals("42", MemberName.of("42").getValue());
    }

    /**
     * Method under test: {@link MemberName#asString()}
     */
    @Test
    void testAsString() {
        assertEquals("42", MemberName.of("42").asString());
    }

    /**
     * Method under test: {@link MemberName#of(String)}
     */
    @Test
    void testOf() {
        assertFalse(MemberName.of("42").isEmpty());
    }

}