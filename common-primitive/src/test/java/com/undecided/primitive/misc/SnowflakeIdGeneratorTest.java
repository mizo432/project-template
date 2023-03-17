package com.undecided.primitive.misc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SnowflakeIdGeneratorTest {

    @Test
    void testGenerateId() {
        SnowflakeIdGenerator generator = new SnowflakeIdGenerator(1L);
        long id1 = generator.generateID();
        long id2 = generator.generateID();
        long id3 = generator.generateID();
        assertThat(id1).isNotEqualTo(id2);
        assertThat(id1).isNotEqualTo(id3);
        assertThat(id2).isNotEqualTo(id3);
    }


}
