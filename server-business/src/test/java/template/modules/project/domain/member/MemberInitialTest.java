package template.modules.project.domain.member;

import org.junit.jupiter.api.Test;
import template.modules.project.domain.model.member.MemberInitial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
