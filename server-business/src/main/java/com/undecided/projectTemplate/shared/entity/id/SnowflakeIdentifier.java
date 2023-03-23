package com.undecided.projectTemplate.shared.entity.id;

import static com.undecided.primitive.object.Objects2.isNull;

import com.undecided.primitive.misc.NodeIdGenerator;
import com.undecided.primitive.misc.SnowflakeIdGenerator;
import com.undecided.projectTemplate.shared.entity.Entity;
import com.undecided.projectTemplate.shared.entity.Identifier;
import com.undecided.projectTemplate.shared.value.AbstractLongValue;
import lombok.Getter;

@Getter
public class SnowflakeIdentifier<E extends Entity<E>> extends AbstractLongValue implements
    Identifier<E> {

    private static final SnowflakeIdentifier<?> EMPTY = new SnowflakeIdentifier<>();


    public SnowflakeIdentifier() {
        super();
    }

    public SnowflakeIdentifier(long value) {
        super(value);
    }

    @SuppressWarnings("unchecked")
    public static <E extends Entity<E>> SnowflakeIdentifier<E> empty() {
        return (SnowflakeIdentifier<E>) EMPTY;

    }

    @Override
    public String asString() {
        if (isEmpty()) {
            return null;
        }
        return String.valueOf(getValue());
    }

    public static <E extends Entity<E>> SnowflakeIdentifier<E> newInstance() {
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
    public static <E extends Entity<E>> SnowflakeIdentifier<E> reconstruct(Long value) {
        if (isNull(value)) {
            return (SnowflakeIdentifier<E>) EMPTY;
        }
        return new SnowflakeIdentifier<>(value);

    }

    public static <E extends Entity<E>> SnowflakeIdentifier<E> of(Long value) {
        return new SnowflakeIdentifier<>(value);
    }

}
