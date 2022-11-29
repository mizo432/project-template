package org.venusPj.projectTemplate.shared.precondition.collection;

import static org.venusPj.projectTemplate.shared.precondition.object.ObjectPreconditions.checkNotNull;
import static org.venusPj.projectTemplate.shared.primitive.object.Objects2.isNull;

import java.util.Collection;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Range;
import org.venusPj.projectTemplate.shared.precondition.object.ObjectPreconditions;

public class CollectionPreconditions {

    /**
     * 参照Collectionが空でない事をチェックします。
     * <pre>
     *   <h3>記述例</h3>
     *   checkNotEmpty(arg,() -&gt; throw new RuntimeException());
     * </pre>
     *
     * @param referenceCollection      参照コレクション
     * @param runtimeExceptionSupplier 実行時例外供給者
     */
    public static <T> void checkNotEmpty(Collection<T> referenceCollection,
        Supplier<RuntimeException> runtimeExceptionSupplier) {
        ObjectPreconditions.checkNotNull(referenceCollection, "referenceCollection");
        if (referenceCollection.isEmpty()) {
            throw runtimeExceptionSupplier.get();

        }

    }

    /**
     * 参照Collectionが空でない事をチェックします。
     * <pre>
     *   <h3>記述例</h3>
     *   checkNotEmpty(arg);
     * </pre>
     *
     * @param referenceCollection 参照コレクション
     * @throws IllegalArgumentException 空でない場合にスローされます。
     */
    public static <T> void checkNotEmpty(Collection<T> referenceCollection) {
        checkNotEmpty(referenceCollection,
            () -> new IllegalArgumentException("参照コレクションの要素が空です。参照コレクションに要素を設定してください。"));

    }

    /**
     * コレクションの全ての要素が存在するかをチェックする
     *
     * @param referenceCollection コレクション
     * @param <T>                 コレクションの要素の型
     * @throws IllegalArgumentException 空でない場合にスローされます。
     */
    public static <T> void checkAllItemPresent(@NotNull Collection<T> referenceCollection) {
        checkAllItemPresent(referenceCollection, () -> {
            return new IllegalArgumentException(
                "referenceCollectionの要素は全て存在しなければいけませんがnullが含まれています");
        });

    }

    /**
     * コレクションの全ての要素が存在するかをチェックする
     *
     * @param referenceCollection      コレクション
     * @param runtimeExceptionSupplier nullの要素があった場合にスローする例外のサプライヤー
     * @param <T>                      コレクションの要素の型
     */
    public static <T> void checkAllItemPresent(@NotNull Collection<T> referenceCollection,
        Supplier<RuntimeException> runtimeExceptionSupplier) {
        checkNotNull(referenceCollection, "referenceArray");
        checkNotNull(runtimeExceptionSupplier, "runtimeExceptionSupplier");

        for (T t : referenceCollection) {
            if (isNull(t)) {
                throw runtimeExceptionSupplier.get();
            }

        }

    }

    public static <T> void checkSize(@NotNull Collection<T> referenceCollection,
        @NotNull Range<Integer> sizeRange) {
        checkSize(referenceCollection, sizeRange, () -> new IllegalArgumentException(
            "referenceCollectionはサイズが" + sizeRange.toString()
                + "でなければなりませんが条件に合致ません　referenceCollection.size():"
                + referenceCollection.size()));

    }

    public static <T> void checkSize(@NotNull Collection<T> referenceCollection,
        @NotNull Range<Integer> sizeRange,
        @NotNull Supplier<RuntimeException> runtimeExceptionSupplier) {
        checkNotNull(referenceCollection, "referenceCollection");
        checkNotNull(sizeRange, "sizeRange");
        checkNotNull(sizeRange, "runtimeExceptionSupplier");
        if (sizeRange.contains(referenceCollection.size())) {
            throw runtimeExceptionSupplier.get();
        }

    }

}
