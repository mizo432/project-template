package com.undecided.projectTemplate.modules.teamMember.domain.member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class MemberInitialTest {

    /**
     * Method under test: {@link MemberInitial#getValue()}
     */
    @Test
    void testGetValue() {
        assertEquals("42", MemberInitial.of("42").getValue());
    }

    /**
     * Method under test: {@link MemberInitial#asString()}
     */
    @Test
    void testAsString() {
        assertEquals("42", MemberInitial.of("42").asString());
    }

    /**
     * Method under test: {@link MemberInitial#of(String)}
     */
    @Test
    void testOf() {
        assertFalse(MemberInitial.of("42").isEmpty());
    }

}
