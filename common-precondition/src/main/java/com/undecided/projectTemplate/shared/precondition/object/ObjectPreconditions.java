package com.undecided.projectTemplate.shared.precondition.object;

import static com.undecided.primitive.object.Objects2.isNull;

import com.undecided.primitive.object.Objects2;
import com.undecided.primitive.string.Strings2;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public class ObjectPreconditions {

    public static <T> void checkNotNull(@NotNull T reference, @NotNull String label) {
        if (Objects2.isNull(label)) {
            throw new IllegalArgumentException("引数のlabelは必須ですが指定されていません");

        }
        if (Strings2.isEmpty(label)) {
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
