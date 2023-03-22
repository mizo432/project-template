package com.undecided.projectTemplate.shared.entity.id;

import static com.undecided.primitive.object.Objects2.isNull;

import com.undecided.primitive.misc.NodeIdGenerator;
import com.undecided.primitive.misc.SnowflakeIdGenerator;
import com.undecided.projectTemplate.shared.value.LongValue;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SnowflakeIdentifier<E> implements
    LongValue<SnowflakeIdentifier<E>>, Serializable {

    private static final SnowflakeIdentifier<?> EMPTY = new SnowflakeIdentifier<>();

    private final Long value;

    public SnowflakeIdentifier() {
        this(null);
    }

    @SuppressWarnings("unchecked")
    public static <E> SnowflakeIdentifier<E> empty() {
        return (SnowflakeIdentifier<E>) EMPTY;
    }

    @Override
    public String asString() {
        if (isEmpty()) {
            return null;
        }
        return String.valueOf(value);
    }

    public static <E> SnowflakeIdentifier<E> newInstance() {
        return new SnowflakeIdentifier<>(
            new SnowflakeIdGenerator(NodeIdGenerator.generateNodeId()).generateID());

    }

    /**
     * データベースから再生成する場合のファクトリーメソッド
     *
     * @param value データベースから取得した値
     * @param <E>   エンティティの型
     * @return 識別子オブジェクト
     */
    @SuppressWarnings("unchecked")
    public static <E> SnowflakeIdentifier<E> reconstruct(Long value) {
        if (isNull(value)) {
            return (SnowflakeIdentifier<E>) EMPTY;
        }
        return new SnowflakeIdentifier<>(value);

    }

    public static <E> SnowflakeIdentifier<E> of(Long value) {
        return new SnowflakeIdentifier<>(value);
    }

    public String toString() {
        if (isNull(value)) {
            return null;
        }
        return value.toString();
    }

}
