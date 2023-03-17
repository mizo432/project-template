package com.undecided.projectTemplate.shared.entity.id;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import com.undecided.projectTemplate.shared.value.StringValue;
import de.huxhorn.sulky.ulid.ULID;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class UildIdentifier<E> implements
    StringValue<UildIdentifier<E>>, Serializable {

    private static final UildIdentifier<?> EMPTY = new UildIdentifier<>();

    private final String value;

    public UildIdentifier() {
        this(null);
    }

    @SuppressWarnings("unchecked")
    public static <E> UildIdentifier<E> empty() {
        return (UildIdentifier<E>) EMPTY;
    }

    @Override
    public String asString() {
        return value;
    }

    public static <E> UildIdentifier<E> newInstance() {
        return new UildIdentifier<E>(new ULID().nextValue().toString());

    }

    /**
     * データベースから再生成する場合のファクトリーメソッド
     *
     * @param value データベースから取得した値
     * @param <E>   エンティティの型
     * @return 識別子オブジェクト
     */
    @SuppressWarnings("unchecked")
    public static <E> UildIdentifier<E> reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return (UildIdentifier<E>) EMPTY;
        }
        return new UildIdentifier<>(value);

    }

    public static <E> UildIdentifier<E> of(String value) {
        StringPreconditions.checkLength(value, 26,
            () -> new IllegalArgumentException("識別子は" + 26 + "桁でなければいけません。 value=" + value));

        return new UildIdentifier<>(value);
    }

}
