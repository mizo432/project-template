package com.undecided.projectTemplate.shared.entity.id;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import com.undecided.projectTemplate.shared.value.StringValue;
import de.huxhorn.sulky.ulid.ULID;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Deprecated
public class UlidIdentifier<E> extends AbstractStringValue implements
        StringValue, Serializable {

    private static final UlidIdentifier<?> EMPTY = new UlidIdentifier<>();


    public UlidIdentifier() {
        super();
    }

    UlidIdentifier(String value) {
        super(value);
    }

    @SuppressWarnings("unchecked")
    public static <E> UlidIdentifier<E> empty() {
        return (UlidIdentifier<E>) EMPTY;
    }

    public static <E> UlidIdentifier<E> newInstance() {
        return new UlidIdentifier<E>(new ULID().nextValue().toString());

    }

    /**
     * データベースから再生成する場合のファクトリーメソッド
     *
     * @param value データベースから取得した値
     * @param <E>   エンティティの型
     * @return 識別子オブジェクト
     */
    @SuppressWarnings("unchecked")
    public static <E> UlidIdentifier<E> reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return (UlidIdentifier<E>) EMPTY;
        }
        return new UlidIdentifier<>(value);

    }

    public static <E> UlidIdentifier<E> of(String value) {
        StringPreconditions.checkLength(value, 26,
                () -> new IllegalArgumentException("識別子は" + 26 + "桁でなければいけません。 value=" + value));

        return new UlidIdentifier<>(value);
    }

}
