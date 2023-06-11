package com.undecided.projectTemplate.shared.entity.id;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.entity.Identifier;
import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import com.undecided.projectTemplate.shared.value.StringValue;
import de.huxhorn.sulky.ulid.ULID;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Deprecated
public class UlidIdentifier extends AbstractStringValue implements
        StringValue, Serializable, Identifier<UlidIdentifier> {

    private static final UlidIdentifier EMPTY = new UlidIdentifier();


    public UlidIdentifier() {
        super();
    }

    UlidIdentifier(String value) {
        super(value);
    }

    @SuppressWarnings("unchecked")
    public static <E> UlidIdentifier empty() {
        return (UlidIdentifier) EMPTY;
    }

    public static <E> UlidIdentifier newInstance() {
        return new UlidIdentifier(new ULID().nextValue().toString());

    }

    /**
     * データベースから再生成する場合のファクトリーメソッド
     *
     * @param value データベースから取得した値
     * @param <E>   エンティティの型
     * @return 識別子オブジェクト
     */
    @SuppressWarnings("unchecked")
    public static <E> UlidIdentifier reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY;
        }
        return new UlidIdentifier(value);

    }

    public static UlidIdentifier of(String value) {
        StringPreconditions.checkLength(value, 26,
                () -> new IllegalArgumentException("識別子は" + 26 + "桁でなければいけません。 value=" + value));

        return new UlidIdentifier(value);
    }

}
