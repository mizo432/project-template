package org.venusPj.projectTemplate.shared.precondition.string;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.venusPj.projectTemplate.shared.precondition.object.ObjectPreconditions.checkNotNull;
import static org.venusPj.projectTemplate.shared.primitive.string.Strings2.isDigit;

import com.google.common.collect.Range;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.shared.primitive.string.Strings2;

public class StringPreconditions {

    public static void checkNotEmpty(@NotNull String reference, @NotNull String label) {
        if (Strings2.isEmpty(label)) {
            throw new IllegalArgumentException(
                "引数のlabelが空白です。引数のlabelに空白は許容されません。");
        }

        checkNotNull(reference, label);
        if (Strings2.isEmpty(reference)) {
            throw new IllegalArgumentException(
                label + "が空白です。" + label + "に空白は許容されません。");
        }

    }

    /**
     * 参照値の全ての文字が10進数字である事をチェックします。
     *
     * @param referenceString          参照値
     * @param runtimeExceptionSupplier 参照値が対象値セットが含まれていない場合返す例外の供給者を指定します。
     */
    public static void checkAllCharactersAreDigits(String referenceString,
        Supplier<RuntimeException> runtimeExceptionSupplier) {
        checkNotNull(referenceString);
        if (!isDigit(referenceString)) {
            throw runtimeExceptionSupplier.get();
        }

    }

    public static void checkLength(@NotNull String reference,
        @NotNull Range<Integer> sizeRange) {
        checkLength(reference, sizeRange, () -> new IllegalArgumentException(
            "referenceはサイズが" + sizeRange.toString()
                + "でなければなりませんが条件に合致ません　reference.length():"
                + reference.length()));

    }

    public static void checkLength(@NotNull String reference,
        @NotNull Range<Integer> sizeRange,
        @NotNull Supplier<RuntimeException> runtimeExceptionSupplier) {
        checkNotNull(reference, "reference");
        checkNotNull(sizeRange, "sizeRange");
        checkNotNull(sizeRange, "runtimeExceptionSupplier");
        if (sizeRange.contains(reference.length())) {
            throw runtimeExceptionSupplier.get();
        }

    }


}
