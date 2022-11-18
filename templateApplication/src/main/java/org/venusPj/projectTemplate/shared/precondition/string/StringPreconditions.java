package org.venusPj.projectTemplate.shared.precondition.string;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.venusPj.projectTemplate.shared.primitive.string.Strings2.isDigit;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.shared.precondition.object.ObjectPreconditions;
import org.venusPj.projectTemplate.shared.primitive.string.Strings2;

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

}
