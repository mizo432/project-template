package org.venusPj.projectTemplate.shared.precondition.array;

import static org.venusPj.projectTemplate.shared.precondition.object.ObjectPreconditions.checkNotNull;
import static org.venusPj.projectTemplate.shared.primitive.object.Objects2.isNull;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Range;
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
        checkNotNull(referenceArray, "referenceArray");
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

    /**
     * 配列の全ての要素が存在するかをチェックする
     *
     * @param referenceArray 配列
     * @param <T>            配列の要素の型
     * @throws IllegalArgumentException 空でない場合にスローされます。
     */
    public static <T> void checkAllItemPresent(@NotNull T[] referenceArray) {
        checkAllItemPresent(referenceArray, () -> {
            return new IllegalArgumentException(
                "referenceArrayの要素は全て存在しなければいけませんがnullが含まれています");
        });

    }

    /**
     * 配列の全ての要素が存在するかをチェックする
     *
     * @param referenceArray           配列
     * @param runtimeExceptionSupplier nullの要素があった場合にスローする例外のサプライヤー
     * @param <T>                      配列の要素の型
     */
    public static <T> void checkAllItemPresent(@NotNull T[] referenceArray,
        Supplier<RuntimeException> runtimeExceptionSupplier) {
        checkNotNull(referenceArray, "referenceArray");
        checkNotNull(runtimeExceptionSupplier, "runtimeExceptionSupplier");

        for (T t : referenceArray) {
            if (isNull(t)) {
                throw runtimeExceptionSupplier.get();
            }

        }

    }

    public static <T> void checkLength(@NotNull T[] referenceArray,
        @NotNull Range<Integer> sizeRange) {
        checkLength(referenceArray, sizeRange, () -> new IllegalArgumentException(
            "referenceArray はサイズが" + sizeRange.toString()
                + "でなければなりませんが条件に合致ません　referenceArray.length:"
                + referenceArray.length));

    }

    public static <T> void checkLength(@NotNull T[] referenceArray,
        @NotNull Range<Integer> sizeRange,
        @NotNull Supplier<RuntimeException> runtimeExceptionSupplier) {
        checkNotNull(referenceArray, "referenceArray");
        checkNotNull(sizeRange, "sizeRange");
        checkNotNull(sizeRange, "runtimeExceptionSupplier");
        if (sizeRange.contains(referenceArray.length)) {
            throw runtimeExceptionSupplier.get();
        }

    }


}
