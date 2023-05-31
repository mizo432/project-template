package com.undecided.primitive.misc;

import com.undecided.primitive.localDate.DateProvider;
import com.undecided.primitive.localDate.LocalDateTimes;
import com.undecided.primitive.localDate.StaticDateTimeProvider;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class SnowflakeIdGeneratorTest {

    @Test
    void testGenerateId() {
        StaticDateTimeProvider.initialize(LocalDateTime.of(2023, 5, 27, 10, 49, 7, 1));
        System.out.println(DateProvider.currentTimeMillis());
        SnowflakeIdGenerator generator = new SnowflakeIdGenerator(1L);
        long id1 = generator.generateID();
        System.out.println(id1);
        long id2 = generator.generateID();
        System.out.println(id2);
        long id3 = generator.generateID();
        System.out.println(id3);
        assertThat(id1).isNotEqualTo(id2);
        assertThat(id1).isNotEqualTo(id3);
        assertThat(id2).isNotEqualTo(id3);
        DateProvider.clear();
        ;
    }

    @Test
    void minimum() {
        StaticDateTimeProvider.initialize(LocalDateTimes.MIN);
        System.out.println(DateProvider.currentTimeMillis());
        SnowflakeIdGenerator generator = new SnowflakeIdGenerator(1L);
        generator.initialise();
        long id1 = generator.generateID();
        System.out.println(id1);
        long id2 = generator.generateID();
        System.out.println(id2);
        long id3 = generator.generateID();
        System.out.println(id3);
        assertThat(id1).isNotEqualTo(id2);
        assertThat(id1).isNotEqualTo(id3);
        assertThat(id2).isNotEqualTo(id3);
        DateProvider.clear();
        ;
    }

    @Test
    void maximum() throws InterruptedException {
        StaticDateTimeProvider.initialize(LocalDateTimes.MAX);
        System.out.println(DateProvider.currentTimeMillis());
        SnowflakeIdGenerator generator = new SnowflakeIdGenerator(1L);
        long id1 = generator.generateID();
        System.out.println(id1);
        long id2 = generator.generateID();
        System.out.println(id2);
        long id3 = generator.generateID();
        System.out.println(id3);
        assertThat(id1).isNotEqualTo(id2);
        assertThat(id1).isNotEqualTo(id3);
        assertThat(id2).isNotEqualTo(id3);
        DateProvider.clear();
        ;
    }

    @Test
    void valueCheck() throws InterruptedException {
        System.out.println(DateProvider.currentTimeMillis());
        SnowflakeIdGenerator generator = new SnowflakeIdGenerator(1L);
        System.out.println("START:" + DateProvider.currentLocalDateTime());
        for (int i = 0; i < 10000; i++) {
            System.out.print(DateProvider.currentLocalDateTime());
            System.out.print(" ");
            System.out.print(i);
            System.out.print(" ");
            System.out.println(generator.generateID());

        }
        System.out.println("END :" + DateProvider.currentLocalDateTime());


    }

}
