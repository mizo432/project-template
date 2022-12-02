package org.venusPj.projectTemplate.shared.entity.id;

import static org.venusPj.primitive.string.Strings2.isEmpty;
import static org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions.checkLength;

import de.huxhorn.sulky.ulid.ULID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.value.StringValue;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Identifier<E extends AbstractEntity<E>> implements
    StringValue<Identifier<E>> {

    private static final Identifier<?> EMPTY = new Identifier<>();

    private final String value;

    public Identifier() {
        this(null);
    }

    @SuppressWarnings("unchecked")
    public static <E extends AbstractEntity<E>> Identifier<E> empty() {
        return (Identifier<E>) EMPTY;
    }

    @Override
    public String asString() {
        return value;
    }

    public static <E extends AbstractEntity<E>> Identifier<E> newInstance() {
        return new Identifier<E>(new ULID().nextValue().toString());

    }

    /**
     * データベースから再生成する場合のファクトリーメソッド
     *
     * @param value データベースから取得した値
     * @param <E>   エンティティの型
     * @return 識別子オブジェクト
     */
    @SuppressWarnings("unchecked")
    public static <E extends AbstractEntity<E>> Identifier<E> reconstruct(String value) {
        if (isEmpty(value)) {
            return (Identifier<E>) EMPTY;
        }
        return new Identifier<>(value);

    }

    public static <E extends AbstractEntity<E>> Identifier<E> of(String value) {
        checkLength(value, 26,
            () -> new IllegalArgumentException("識別子は" + 26 + "桁でなければいけません。 value=" + value));

        return new Identifier<>(value);
    }

}
