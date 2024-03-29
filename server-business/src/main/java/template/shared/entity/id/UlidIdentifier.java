package template.shared.entity.id;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import de.huxhorn.sulky.ulid.ULID;
import lombok.Getter;
import template.shared.entity.Identifier;
import template.shared.value.AbstractStringValue;
import template.shared.value.StringValue;

import java.io.Serializable;

@Getter
public class UlidIdentifier extends AbstractStringValue implements
        StringValue, Serializable, Identifier<UlidIdentifier> {

    private static final UlidIdentifier EMPTY_VALUE = new UlidIdentifier();


    public UlidIdentifier() {
        super();
    }

    /* default*/UlidIdentifier(final String value) {
        super(value);
    }

    @SuppressWarnings("unchecked")

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
    public static <E> UlidIdentifier reconstruct(final String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY_VALUE;
        }
        return new UlidIdentifier(value);

    }

    public static UlidIdentifier of(final String value) {
        StringPreconditions.checkLength(value, 26,
                () -> new IllegalArgumentException("識別子は" + 26 + "桁でなければいけません。 value=" + value));

        return new UlidIdentifier(value);
    }

}
