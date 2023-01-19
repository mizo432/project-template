package com.undecided.projectTemplate.shared.responsibility.layer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.undecided.projectTemplate.shared.value.name.Name;
import org.junit.jupiter.api.Test;

class LayerTypeTest {

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LayerType#valueOf(String)}
     *   <li>{@link LayerType#getLayerTypename()}
     *   <li>{@link LayerType#getResponsibility()}
     * </ul>
     */
    @Test
    void testValueOf() {
        // Arrange
        String name = "PRESENTATION_LAYER";

        // Act
        LayerType actualValueOfResult = LayerType.valueOf(name);

        // Assert
        String expectedValue = "プレゼンテーション層";
        Name name1 = actualValueOfResult.getLayerTypename();
        String actualValue = name1.getValue();
        assertEquals(expectedValue, actualValue);
    }
}

