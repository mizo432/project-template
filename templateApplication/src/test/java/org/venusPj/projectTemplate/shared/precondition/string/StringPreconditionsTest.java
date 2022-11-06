package org.venusPj.projectTemplate.shared.precondition.string;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.shared.primitive.string.Strings2;

public class StringPreconditionsTest {

    /**
     * Method under test: {@link StringPreconditions#checkNotEmpty(String, String)}
     */
    @Nested
    class checkNotEmpty {

        @Test
        void _参照値がNOT_EMPTYの場合スローされない() {
            // Arrange
            String reference = "Reference";
            String label = "label";

            // Act
            StringPreconditions.checkNotEmpty(reference, label);
        }

        @Test
        void _参照値がEMPTYの場合引数エラーをスローする() {
            // Arrange
            String reference = Strings2.EMPTY;
            String label = "label";

            // Act and Assert
            assertThrows(IllegalArgumentException.class,
                () -> StringPreconditions.checkNotEmpty(reference, label));
        }

        @Test
        void _参照値がnullの場合引数エラーをスローする() {
            // Arrange
            String reference = null;
            String label = "label";

            // Act and Assert
            assertThrows(NullPointerException.class,
                () -> StringPreconditions.checkNotEmpty(reference, label));
        }

        @Test
        void testCheckNotEmpty3() {
            // Arrange
            String reference = "Reference";
            String label = null;

            // Act and Assert
            assertThrows(IllegalArgumentException.class,
                () -> StringPreconditions.checkNotEmpty(reference, label));
        }

    }

}
