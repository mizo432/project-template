package org.venusPj.projectTemplate.shared.primitive.localDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LocalDatesTest {


    /**
     * Method under test: {@link LocalDates#tryToParse(String)}
     */
    @Nested
    class tryToParse {

        @Test
        void testTryToParse() {
            assertThrows(IllegalArgumentException.class, () -> LocalDates.tryToParse("String"));
            assertThrows(IllegalArgumentException.class, () -> LocalDates.tryToParse(null));
        }

        @Test
        void _2桁の数字03を渡した場合当月3日を返す() {
            StaticDateProvider.initialize(LocalDate.of(2022, 11, 15));
            LocalDate actualTryToParseResult = LocalDates.tryToParse("03");

            System.out.println(actualTryToParseResult);
            assertThat(actualTryToParseResult).isEqualTo(LocalDate.of(2022, 11, 3));
            DateProvider.clear();

        }

        @Test
        void _2桁の数字13を渡した場合当月13日を返す() {
            StaticDateProvider.initialize(LocalDate.of(2022, 11, 15));
            LocalDate actualTryToParseResult = LocalDates.tryToParse("13");

            System.out.println(actualTryToParseResult);
            assertThat(actualTryToParseResult).isEqualTo(LocalDate.of(2022, 11, 13));
            DateProvider.clear();

        }

        @Test
        void _4桁の数字1103を渡した場合当月3日を返す() {
            StaticDateProvider.initialize(LocalDate.of(2022, 11, 15));
            LocalDate actualTryToParseResult = LocalDates.tryToParse("1103");

            System.out.println(actualTryToParseResult);
            assertThat(actualTryToParseResult).isEqualTo(LocalDate.of(2022, 11, 3));
            DateProvider.clear();

        }

        @Test
        void _4桁の数字1113を渡した場合当月13日を返す() {
            StaticDateProvider.initialize(LocalDate.of(2022, 11, 15));
            LocalDate actualTryToParseResult = LocalDates.tryToParse("1113");

            System.out.println(actualTryToParseResult);
            assertThat(actualTryToParseResult).isEqualTo(LocalDate.of(2022, 11, 13));
            DateProvider.clear();

        }

        @Test
        void _8桁の数字20211103を渡した場合当月3日を返す() {
            StaticDateProvider.initialize(LocalDate.of(2022, 11, 15));
            LocalDate actualTryToParseResult = LocalDates.tryToParse("20211103");

            System.out.println(actualTryToParseResult);
            assertThat(actualTryToParseResult).isEqualTo(LocalDate.of(2021, 11, 3));
            DateProvider.clear();

        }

        @Test
        void _8桁の数字20211113を渡した場合当月13日を返す() {
            StaticDateProvider.initialize(LocalDate.of(2022, 11, 15));
            LocalDate actualTryToParseResult = LocalDates.tryToParse("20211113");

            System.out.println(actualTryToParseResult);
            assertThat(actualTryToParseResult).isEqualTo(LocalDate.of(2021, 11, 13));
            DateProvider.clear();

        }

        @Test
        @DisplayName("10桁の数字で月の最終日を超える値2022-11-31を渡した場合当月翌月に日付を繰り越した日付2022-12-1を返す")
        void _10桁の数字で月の最終日を超える値を渡した場合当月翌月に日付を繰り越した日付を返す() {
            StaticDateProvider.initialize(LocalDate.of(2022, 11, 15));
            LocalDate actualTryToParseResult = LocalDates.tryToParse("2022-11-31");

            System.out.println(actualTryToParseResult);
            assertThat(actualTryToParseResult).isEqualTo(LocalDate.of(2022, 12, 1));
            DateProvider.clear();

        }

    }

}

