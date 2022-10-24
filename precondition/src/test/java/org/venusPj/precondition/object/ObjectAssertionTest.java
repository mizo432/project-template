package org.venusPj.precondition.object;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Supplier;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ObjectAssertionTest {

    /**
     * Method under test: {@link ObjectAssertion#assertNotNull(Object, Supplier)}
     */
    @Nested
    class checkNotNull {

        @Test
        void testAssertNotNull() {
            // Arrange
            String reference = "Reference";
            Supplier<RuntimeException> exceptionSupplier = null;

            // Act and Assert
            assertThrows(IllegalArgumentException.class,
                () -> ObjectAssertion.assertNotNull(reference, exceptionSupplier));
        }

        /**
         * Method under test: {@link ObjectAssertion#assertNotNull(Object, Supplier)}
         */
        @Test
        void testAssertNotNull2() {
            // Arrange
            Object reference = null;
            Supplier<RuntimeException> exceptionSupplier = null;

            // Act and Assert
            assertThrows(IllegalArgumentException.class,
                () -> ObjectAssertion.assertNotNull(reference, exceptionSupplier));
        }

    }

    @Nested
    class checkNotNullNonExceptionSupplier {

        /**
         * Method under test: {@link ObjectAssertion#assertNotNull(Object)}
         */
        @Test
        void testAssertNotNull() {
            // Arrange
            Object reference = null;

            // Act and Assert
            assertThrows(NullPointerException.class,
                () -> ObjectAssertion.assertNotNull(reference));
        }

    }

}

