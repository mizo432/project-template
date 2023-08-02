package com.undecided.template.shared.entity;

import com.undecided.primitive.misc.NodeIdGenerator;
import com.undecided.primitive.misc.SnowflakeIdGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SnowflakeId {
    private final Long value;

    public static SnowflakeId reconstruct(Long value) {
        return new SnowflakeId(value);
    }

    public static SnowflakeId newInstance() {
        return new SnowflakeId(
                new SnowflakeIdGenerator(NodeIdGenerator.generateNodeId()).generateID());


    }

}
