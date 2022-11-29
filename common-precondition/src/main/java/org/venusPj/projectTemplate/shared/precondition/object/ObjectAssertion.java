package org.venusPj.projectTemplate.shared.precondition.object;

import static org.venusPj.primitive.object.Objects2.isNull;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public class ObjectAssertion {

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param reference an object reference
     * @return the non-null reference that was validated
     * @throws NullPointerException if {@code reference} is null
     */
    public static <T> void assertNotNull(@NotNull T reference) {
        assertNotNull(reference, NullPointerException::new);

    }

    public static <T, RE extends RuntimeException> void assertNotNull(@NotNull T reference,
        @NotNull Supplier<RE> exceptionSupplier) {
        if (isNull(exceptionSupplier)) {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        }

        if (isNull(reference)) {
            throw exceptionSupplier.get();
        }
    }

    public static <T> void assertArgument(boolean b) {
        assertArgument(b, IllegalArgumentException::new);

    }

    public static <T, RE extends RuntimeException> void assertArgument(boolean b,
        @NotNull Supplier<RE> exceptionSupplier) {
        if (isNull(exceptionSupplier)) {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        }

        if (!b) {
            throw exceptionSupplier.get();
        }
    }

    public static <T> void assertState(boolean b) {
        assertState(b, IllegalStateException::new);

    }

    public static <T, RE extends RuntimeException> void assertState(boolean b,
        @NotNull Supplier<RE> exceptionSupplier) {
        if (isNull(exceptionSupplier)) {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        }

        if (!b) {
            throw exceptionSupplier.get();
        }
    }

}
