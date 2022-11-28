package org.venusPj.projectTemplate.shared.precondition.array;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.common.collect.Range;
import java.util.function.Supplier;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venusPj.projectTemplate.shared.test.TestSize;

@Tag(TestSize.SMALL)
class ArrayPreconditionsTest {

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[])}
     */
    @Test
    void testCheckNotEmpty() {
        ArrayPreconditions.checkNotEmpty(new Object[]{"Reference Array"});
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[])}
     */
    @Test
    void testCheckNotEmpty2() {
        assertThrows(IllegalArgumentException.class, () ->
            ArrayPreconditions.checkNotEmpty(null));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkNotEmpty(Object[])}
     */
    @Test
    void testCheckNotEmpty3() {
        assertThrows(IllegalArgumentException.class,
            () -> ArrayPreconditions.checkNotEmpty(new Object[]{}));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkAllItemPresent(Object[])}
     */
    @Test
    void testCheckAllItemPresent() {
        // Arrange
        Object[] referenceArray = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> ArrayPreconditions.checkAllItemPresent(referenceArray));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkAllItemPresent(Object[])}
     */
    @Test
    void testCheckAllItemPresent2() {
        // Arrange
        Object object = null;
        Object[] referenceArray = new Object[]{object};

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> ArrayPreconditions.checkAllItemPresent(referenceArray));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkAllItemPresent(Object[], Supplier)}
     */
    @Test
    void testCheckAllItemPresent3() {
        // Arrange
        Object[] referenceArray = null;
        Supplier<RuntimeException> runtimeExceptionSupplier = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> ArrayPreconditions.checkAllItemPresent(referenceArray, runtimeExceptionSupplier));

    }

    /**
     * Method under test: {@link ArrayPreconditions#checkLength(Object[], Range)}
     */
    @Test
    void testCheckLength() {
        // Arrange
        String string = "Reference Array";
        Object[] referenceArray = new Object[]{string};
        Range<Integer> sizeRange = Range.all();

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> ArrayPreconditions.checkLength(referenceArray, sizeRange));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkLength(Object[], Range)}
     */
    @Test
    void testCheckLength2() {
        // Arrange
        Object[] referenceArray = null;
        Range<Integer> sizeRange = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> ArrayPreconditions.checkLength(referenceArray, sizeRange));
    }

    /**
     * Method under test: {@link ArrayPreconditions#checkLength(Object[], Range)}
     */
    @Test
    void testCheckLength3() {
        // Arrange
        Object[] referenceArray = null;
        Range<Integer> sizeRange = Range.all();

        // Act and Assert
        assertThrows(IllegalArgumentException.class,
            () -> ArrayPreconditions.checkLength(referenceArray, sizeRange));
    }


}

