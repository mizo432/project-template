package com.undecided.primitive.misc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NodeIdGeneratorTest {

    @Test
    void testGenerateId() {
        long nodeId1 = NodeIdGenerator.generateNodeId();
        long nodeId2 = NodeIdGenerator.generateNodeId();
        assertThat(nodeId1)
            .isEqualTo(nodeId2);
    }
}
