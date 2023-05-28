package com.undecided.primitive.localDate;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


class DateProviderTest {

    /**
     * Method under test: {@link DateProvider#currentTimeMillis()}
     */
    @Nested
    class currentTimeMillisTest {
        @Test
        void example() {
            StaticDateTimeProvider.initialize(LocalDateTime.of(2023, 5, 27, 10, 34, 31, 1));

            long actual = DateProvider.currentTimeMillis();

            assertThat(actual).isEqualTo(1685151271000L);

            DateProvider.clear();
        }

        @Test
        void minimum() {
            StaticDateTimeProvider.initialize(LocalDateTimes.MIN);

            long actual = DateProvider.currentTimeMillis();

            assertThat(actual).isEqualTo(-62167252739000L);

            DateProvider.clear();
        }

        @Test
        void maximum() {
            StaticDateTimeProvider.initialize(LocalDateTimes.MAX);

            long actual = DateProvider.currentTimeMillis();

            assertThat(actual).isEqualTo(253402268399999L);

            DateProvider.clear();
        }

    }

}

