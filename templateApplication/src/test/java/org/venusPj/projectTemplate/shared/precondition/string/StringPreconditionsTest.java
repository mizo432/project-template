package org.venusPj.projectTemplate.shared.precondition.string;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.shared.primitive.string.Strings2;
import org.venusPj.projectTemplate.shared.test.TestSize;

@Tag(TestSize.SMALL)
public class StringPreconditionsTest {

    /**
     * Method under test: {@link StringPreconditions#checkLength(String, Range)}
     */
    @Test
    void testCheckLength() {
        // Arrange
        String reference = "Reference";
        Range<Integer> sizeRange = Range.all();

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> StringPreconditions.checkLength(reference, sizeRange));
    }

    /**
     * Method under test: {@link StringPreconditions#checkLength(String, Range)}
     */
    @Test
    void testCheckLength2() {
        // Arrange
        String reference = null;
        Range<Integer> sizeRange = Range.all();

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> StringPreconditions.checkLength(reference, sizeRange));
    }

    /**
     * Method under test: {@link StringPreconditions#checkLength(String, Range)}
     */
    @Test
    void testCheckLength3() {
        // Arrange
        String reference = "Reference";
        Range<Integer> sizeRange = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> StringPreconditions.checkLength(reference, sizeRange));
    }

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
