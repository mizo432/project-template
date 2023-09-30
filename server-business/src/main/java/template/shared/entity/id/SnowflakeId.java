package template.shared.entity.id;

import com.undecided.primitive.misc.NodeIdGenerator;
import com.undecided.primitive.misc.SnowflakeIdGenerator;
import lombok.Getter;
import org.jetbrains.annotations.VisibleForTesting;
import org.seasar.doma.Domain;
import template.shared.entity.Identifier;
import template.shared.value.AbstractLongValue;

import java.io.Serial;
import java.io.Serializable;

import static com.undecided.primitive.object.Objects2.isNull;

/**
 * スノーフレークID.
 */
@Getter
@Domain(valueType = Long.class, factoryMethod = "reconstruct")
public class SnowflakeId extends AbstractLongValue implements
        Identifier<SnowflakeId>, Serializable {
    public static final SnowflakeId EMPTY_VALUE = new SnowflakeId();
    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * コンストラクター.
     */
    public SnowflakeId() {
        super();

    }

    /**
     * コンストラクター.
     *
     * @param value 値
     */
    /* default */SnowflakeId(final long value) {
        super(value);

    }

    @Override
    public String asString() {
        if (isEmpty()) {
            return null;
        }
        return String.valueOf(getValue());
    }

    public static SnowflakeId newInstance() {
        return new SnowflakeId(
                new SnowflakeIdGenerator(NodeIdGenerator.generateNodeId()).generateID());

    }

    /**
     * データベースから再生成する場合のファクトリーメソッド
     *
     * @param value データベースから取得した値
     * @return 識別子オブジェクト
     */
    public static SnowflakeId reconstruct(final Long value) {
        if (isNull(value)) {
            return EMPTY_VALUE;
        }
        return new SnowflakeId(value);

    }

    @VisibleForTesting
    public static <E> SnowflakeId of(final Long value) {
        return new SnowflakeId(value);

    }

}
