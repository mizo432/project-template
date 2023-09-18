package template.shared.entity.id;

import com.undecided.primitive.misc.NodeIdGenerator;
import com.undecided.primitive.misc.SnowflakeIdGenerator;
import lombok.Getter;
import org.jetbrains.annotations.VisibleForTesting;
import org.seasar.doma.Domain;
import template.shared.entity.Identifier;
import template.shared.value.AbstractLongValue;

import java.io.Serializable;

import static com.undecided.primitive.object.Objects2.isNull;

/**
 * スノーフレークID.
 */
@Getter
@Domain(valueType = Long.class, factoryMethod = "reconstruct")
public class SnowflakeId extends AbstractLongValue implements
        Identifier<SnowflakeId>, Serializable {


    private static final SnowflakeId EMPTY = new SnowflakeId();


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
    SnowflakeId(long value) {
        super(value);

    }

    public static SnowflakeId empty() {
        return EMPTY;

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
    public static SnowflakeId reconstruct(Long value) {
        if (isNull(value)) {
            return EMPTY;
        }
        return new SnowflakeId(value);

    }

    @VisibleForTesting
    public static <E> SnowflakeId of(Long value) {
        return new SnowflakeId(value);

    }

}
