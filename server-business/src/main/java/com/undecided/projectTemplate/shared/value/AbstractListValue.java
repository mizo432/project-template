package com.undecided.projectTemplate.shared.value;

import com.undecided.primitive.list.Lists2;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

import static com.undecided.primitive.list.Lists2.newArrayList;

/**
 * リストを保持する値オブジェクトの基底クラス
 *
 * @param <E> 保持する要素の型
 */
public abstract class AbstractListValue<E> implements ListValue<E> {
    /**
     * 保持している値
     */
    protected final List<E> value = newArrayList();

    /**
     * コンストラクター
     */
    protected AbstractListValue() {

    }

    /**
     * コンストラクター
     *
     * @param value 値
     */

    protected AbstractListValue(@NotNull Collection<E> value) {
        this.value.addAll(value);

    }

    @Override
    public List<E> getValue() {
        return Lists2.unmodifiableList(value);
    }

    @Override
    public boolean isEmpty() {
        return value.isEmpty();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
