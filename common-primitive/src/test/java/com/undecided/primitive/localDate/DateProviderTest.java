package com.undecided.primitive.localDate;

import com.undecided.test.size.SmallTest;
import org.junit.jupiter.api.Nested;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


class DateProviderTest {

    /**
     * Method under test: {@link DateProvider#currentTimeMillis()}
     */
    @Nested
    class currentTimeMillisTest {
        @SmallTest
        void example() {
            StaticDateTimeProvider.initialize(LocalDateTime.of(2023, 5, 27, 10, 34, 31, 1));

            long actual = DateProvider.currentTimeMillis();

            //          assertThat(actual).isEqualTo(1685151271000L);


            DateProvider.clear();
        }

        @SmallTest
        void minimum() {
            StaticDateTimeProvider.initialize(LocalDateTimes.MIN);

            long actual = DateProvider.currentTimeMillis();

//            assertThat(actual).isEqualTo(-62167252739000L);

            DateProvider.clear();
        }

        @SmallTest
        void maximum() {
            StaticDateTimeProvider.initialize(LocalDateTimes.MAX);

            long actual = DateProvider.currentTimeMillis();

//            assertThat(actual).isEqualTo(253402268399999L);

            DateProvider.clear();
        }

    }

    /**
     * Method under test: {@link DateProvider#currentLocalDate()}
     */
    @Nested
    class currentLocalDateATest {
        @SmallTest
        void example() {
            StaticDateTimeProvider.initialize(LocalDateTime.of(2023, 5, 27, 10, 34, 31, 1));

            final LocalDate actual = DateProvider.currentLocalDate();

            assertThat(actual).isEqualTo(LocalDate.of(2023, 5, 27));


            DateProvider.clear();
        }

        @SmallTest
        void minimum() {
            StaticDateTimeProvider.initialize(LocalDateTimes.MIN);

            final LocalDate actual = DateProvider.currentLocalDate();

//            assertThat(actual).isEqualTo(LocalDate.MIN);

            DateProvider.clear();
        }

        @SmallTest
        void maximum() {
            StaticDateTimeProvider.initialize(LocalDateTimes.MAX);

            final LocalDate actual = DateProvider.currentLocalDate();
//            assertThat(actual).isEqualTo(LocalDate.MAX);

            DateProvider.clear();
        }

    }

}

