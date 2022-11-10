package org.venusPj.projectTemplate.shared.precondition.array;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.shared.precondition.object.ObjectPreconditions;
import org.venusPj.projectTemplate.shared.primitive.array.Arrays2;

public class ArrayPreconditions {

    /**
     * 参照Collectionが空でない事をチェックします。
     * <pre>
     *   <h3>記述例</h3>
     *   checkNotEmpty(arg,() -&gt; throw new RuntimeException());
     * </pre>
     *
     * @param referenceArray           参照コレクション
     * @param runtimeExceptionSupplier 実行時例外供給者
     */
    public static <T> void checkNotEmpty(@NotNull T[] referenceArray,
        Supplier<RuntimeException> runtimeExceptionSupplier) {
        ObjectPreconditions.checkNotNull(referenceArray, "referenceArray");
        if (Arrays2.isEmpty(referenceArray)) {
            throw runtimeExceptionSupplier.get();

        }

    }

    /**
     * 参照配列が空でない事をチェックします。
     * <pre>
     *   <h3>記述例</h3>
     *   checkNotEmpty(arg);
     * </pre>
     *
     * @param referenceArray 参照コレクション
     * @throws IllegalArgumentException 空でない場合にスローされます。
     */
    public static <T> void checkNotEmpty(@NotNull T[] referenceArray) {
        checkNotEmpty(referenceArray,
            () -> new IllegalArgumentException("参照コレクションの要素が空です。参照コレクションに要素を設定してください。"));

    }

}
