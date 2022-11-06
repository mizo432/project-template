package org.venusPj.projectTemplate.shared.precondition.object;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Supplier;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ObjectPreconditionsTest {

    @Nested
    class checkNotNull {

        @Nested
        class withLabel {

            /**
             * Method under test: {@link ObjectPreconditions#checkNotNull(Object, String)}
             */
            @Test
            void testCheckNotNull() {
                // Arrange
                Object reference = null;
                String label = null;

                // Act and Assert
                assertThrows(IllegalArgumentException.class,
                    () -> ObjectPreconditions.checkNotNull(reference, label));
            }

            /**
             * Method under test: {@link ObjectPreconditions#checkNotNull(Object, String)}
             */
            @Test
            void testCheckNotNull2() {
                // Arrange
                String reference = "Reference";
                String label = null;

                // Act and Assert
                assertThrows(IllegalArgumentException.class,
                    () -> ObjectPreconditions.checkNotNull(reference, label));
            }

        }

        @Nested
        class withSupplier {

            /**
             * Method under test: {@link ObjectPreconditions#checkNotNull(Object, Supplier)}
             */
            @Test
            void testCheckNotNull3() {
                // Arrange
                String reference = "Reference";
                Supplier<RuntimeException> exceptionSupplier = null;

                // Act and Assert
                assertThrows(IllegalArgumentException.class,
                    () -> ObjectPreconditions.checkNotNull(reference, exceptionSupplier));
            }

            /**
             * Method under test: {@link ObjectPreconditions#checkNotNull(Object, Supplier)}
             */
            @Test
            void testCheckNotNull4() {
                // Arrange
                Object reference = null;
                Supplier<RuntimeException> exceptionSupplier = null;

                // Act and Assert
                assertThrows(IllegalArgumentException.class,
                    () -> ObjectPreconditions.checkNotNull(reference, exceptionSupplier));
            }

        }


    }

    @Nested
    class checkArgument {

        /**
         * Method under test: {@link ObjectPreconditions#checkArgument(boolean)}
         */
        @Test
        void testCheckArgument() {
            // Arrange
            boolean b = false;

            // Act and Assert
            assertThrows(IllegalArgumentException.class,
                () -> ObjectPreconditions.checkArgument(b));
        }

        @Nested
        class withSupplier {

            /**
             * Method under test: {@link ObjectPreconditions#checkArgument(boolean, Supplier)}
             */
            @Test
            void testCheckArgument2() {
                // Arrange
                boolean b = true;
                Supplier<RuntimeException> exceptionSupplier = null;

                // Act and Assert
                assertThrows(IllegalArgumentException.class,
                    () -> ObjectPreconditions.checkArgument(b, exceptionSupplier));
            }

        }


    }

    @Nested
    class checkState {

        /**
         * Method under test: {@link ObjectPreconditions#checkState(boolean)}
         */
        @Test
        void testCheckState() {
            // Arrange
            boolean b = false;

            // Act and Assert
            assertThrows(IllegalStateException.class, () -> ObjectPreconditions.checkState(b));
        }

        @Nested
        class withSupplier {

            /**
             * Method under test: {@link ObjectPreconditions#checkState(boolean, Supplier)}
             */
            @Test
            void testCheckState2() {
                // Arrange
                boolean b = true;
                Supplier<RuntimeException> exceptionSupplier = null;

                // Act and Assert
                assertThrows(IllegalArgumentException.class,
                    () -> ObjectPreconditions.checkState(b, exceptionSupplier));
            }

        }


    }

}

