package com.undecided.projectTemplate.shared.precondition.string;

import static com.undecided.primitive.string.Strings2.isDigit;

import com.google.common.collect.Range;
import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.precondition.object.ObjectPreconditions;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public class StringPreconditions {

    public static void checkNotEmpty(@NotNull String reference, @NotNull String label) {
        if (Strings2.isEmpty(label)) {
            throw new IllegalArgumentException(
                "引数のlabelが空白です。引数のlabelに空白は許容されません。");
        }

        ObjectPreconditions.checkNotNull(reference, label);
        if (Strings2.isEmpty(reference)) {
            throw new IllegalArgumentException(
                label + "が空白です。" + label + "に空白は許容されません。");
        }

    }

    /**
     * 参照値の全ての文字が10進数字である事をチェックします。
     *
     * @param reference                参照値
     * @param runtimeExceptionSupplier 参照値が対象値セットが含まれていない場合返す例外の供給者を指定します。
     */
    public static void checkAllCharactersAreDigits(@NotNull String reference,
        Supplier<RuntimeException> runtimeExceptionSupplier) {
        ObjectPreconditions.checkNotNull(reference, "referenceString");
        if (!isDigit(reference)) {
            throw runtimeExceptionSupplier.get();
        }

    }

    public static void checkLength(@NotNull String reference,
        @NotNull Range<Integer> sizeRange) {
        checkLength(reference, sizeRange, () -> new IllegalArgumentException(
            "referenceはサイズが" + sizeRange
                + "でなければなりませんが条件に合致ません　reference.length():"
                + reference.length()));

    }

    public static void checkLength(@NotNull String reference,
        @NotNull Range<Integer> sizeRange,
        @NotNull Supplier<RuntimeException> runtimeExceptionSupplier) {
        ObjectPreconditions.checkNotNull(reference, "reference");
        ObjectPreconditions.checkNotNull(sizeRange, "sizeRange");
        ObjectPreconditions.checkNotNull(sizeRange, "runtimeExceptionSupplier");
        if (sizeRange.contains(reference.length())) {
            throw runtimeExceptionSupplier.get();
        }

    }


    public static void checkLength(String reference, int length) {
        ObjectPreconditions.checkNotNull(reference, "reference");
        checkLength(reference, length, () -> new IllegalArgumentException(
            "reference" + length + "桁でなければいけません。 reference=" + reference));

    }

    public static void checkLength(String reference, int length,
        @NotNull Supplier<RuntimeException> runtimeExceptionSupplier) {
        ObjectPreconditions.checkNotNull(reference, "reference");
        ObjectPreconditions.checkNotNull(runtimeExceptionSupplier, "runtimeExceptionSupplier");
        if (length != reference.length()) {
            throw runtimeExceptionSupplier.get();
        }

    }
}
