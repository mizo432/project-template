package template.modules.story.efort;

import org.junit.jupiter.api.Test;
import template.modules.story.domain.model.efort.Effort;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EffortTest {

    /**
     * Method under test: {@link Effort#of(Integer)}
     */
    @Test
    void testOf() {
        // Arrange, Act and Assert
        assertEquals(42, Effort.of(42).getValue().intValue());
    }

    /**
     * Method under test: {@link Effort#reconstruct(Integer)}
     */
    @Test
    void testReconstruct() {
        // Arrange, Act and Assert
        assertEquals(42, Effort.reconstruct(42).getValue().intValue());
    }
}

