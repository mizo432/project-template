package template.shared.value;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static com.undecided.projectTemplate.shared.precondition.object.ObjectPreconditions.checkNotNull;

public class ValuePreconditions {

    /**
     * @param reference 検査値
     * @param argName   引数名
     * @param <E>       検査値の型
     */
    public static <E> void checkNotEmpty(@NotNull final StringValue reference,
                                         @NotNull final String argName) {
        checkNotNull(argName, "argName");
        checkNotEmpty(reference, () -> new IllegalArgumentException(
                "引数の" + argName + "は必須ですが指定されていません"));

    }

    public static <E, RE extends RuntimeException> void checkNotEmpty(
            @NotNull final StringValue reference,
            @NotNull final Supplier<RE> exceptionSupplier) {
        checkNotNull(exceptionSupplier, (Supplier<IllegalArgumentException>) () -> {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        });

        if (reference.isEmpty()) {
            throw exceptionSupplier.get();
        }
    }

    public static <E, RE extends RuntimeException> void checkNotEmpty(
            @NotNull final Value reference,
            @NotNull final Supplier<RE> exceptionSupplier) {
        checkNotNull(exceptionSupplier, (Supplier<IllegalArgumentException>) () -> {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        });

        if (reference.isEmpty()) {
            throw exceptionSupplier.get();
        }
    }

    public static <E, RE extends RuntimeException> void checkNotEmpty(
            @NotNull final Value reference,
            @NotNull final String argName) {
        checkNotNull(argName, "argName");
        checkNotEmpty(reference, () -> new IllegalArgumentException(
                "引数の" + argName + "は必須ですが指定されていません"));

    }

}
