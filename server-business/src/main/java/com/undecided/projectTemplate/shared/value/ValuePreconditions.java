package com.undecided.projectTemplate.shared.value;

import static com.undecided.projectTemplate.shared.precondition.object.ObjectPreconditions.checkNotNull;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public class ValuePreconditions {

    /**
     * @param reference 検査値
     * @param argName   引数名
     * @param <E>       検査値の型
     */
    public static <E> void checkNotEmpty(@NotNull StringValue<E> reference,
        @NotNull String argName) {
        checkNotNull(argName, "argName");
        checkNotEmpty(reference, () -> new IllegalArgumentException(
            "引数の" + argName + "は必須ですが指定されていません"));

    }

    public static <E, RE extends RuntimeException> void checkNotEmpty(
        @NotNull StringValue<E> reference,
        @NotNull Supplier<RE> exceptionSupplier) {
        checkNotNull(exceptionSupplier, (Supplier<IllegalArgumentException>) () -> {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        });

        if (reference.isEmpty()) {
            throw exceptionSupplier.get();
        }
    }

}
