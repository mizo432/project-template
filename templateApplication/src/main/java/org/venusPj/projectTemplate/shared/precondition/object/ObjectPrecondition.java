package org.venusPj.projectTemplate.shared.precondition.object;

import static org.venusPj.projectTemplate.shared.primitive.object.Objects2.isNull;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public class ObjectPrecondition {

    public static <T> void checkNotNull(@NotNull T reference, @NotNull String label) {
        if (isNull(label)) {
            throw new IllegalArgumentException("引数のlabelは必須ですが指定されていません");
        }
        checkNotNull(reference, () -> new NullPointerException(label + "は必須です"));

    }

    public static <T, RE extends RuntimeException> void checkNotNull(@NotNull T reference,
        @NotNull Supplier<RE> exceptionSupplier) {
        if (isNull(exceptionSupplier)) {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        }

        if (isNull(reference)) {
            throw exceptionSupplier.get();
        }
    }

    public static <T> void checkArgument(boolean b) {
        checkArgument(b, IllegalArgumentException::new);

    }

    public static <T, RE extends RuntimeException> void checkArgument(boolean b,
        @NotNull Supplier<RE> exceptionSupplier) {
        if (isNull(exceptionSupplier)) {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        }

        if (!b) {
            throw exceptionSupplier.get();
        }
    }

    public static <T> void checkState(boolean b) {
        checkState(b, IllegalStateException::new);

    }

    public static <T, RE extends RuntimeException> void checkState(boolean b,
        @NotNull Supplier<RE> exceptionSupplier) {
        if (isNull(exceptionSupplier)) {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        }

        if (!b) {
            throw exceptionSupplier.get();
        }
    }

}
