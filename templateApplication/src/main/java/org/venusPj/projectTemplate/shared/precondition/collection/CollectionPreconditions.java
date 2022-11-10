package org.venusPj.projectTemplate.shared.precondition.collection;

import java.util.Collection;
import java.util.function.Supplier;
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

}
