package org.venusPj.projectTemplate.shared.primitive.localDate;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions.checkNotEmpty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions;
import org.venusPj.projectTemplate.shared.primitive.string.Strings2;

public class LocalDates {

    public static LocalDate tryToParse(@NotNull String string) {
        checkNotNull(string, "引数がしていされていません");
        checkNotEmpty(string, "引数がしていされていません");
        if (Strings2.length(string) <= 8) {
            StringPreconditions.checkAllCharactersAreDigits(string,
                () -> new IllegalArgumentException(
                    "引数に10進数の数字以外の文字が含まれています。引数:" + string));
            if (Strings2.length(string) == 1) {
                // 月内の日にちを1桁で渡した場合
                return LocalDate.parse(
                    DateProvider.currentYearMonth().format(DateTimeFormatter.ofPattern("yyyyMM"))
                        + Strings2.padStart(string, 2, '0'),
                    DateTimeFormatter.ofPattern("yyyyMMdd").withResolverStyle(
                        ResolverStyle.LENIENT));
            }
            if (Strings2.length(string) == 2) {
                // 月内の日にちを2桁で渡した場合
                return LocalDate.parse(
                    DateProvider.currentYearMonth().format(DateTimeFormatter.ofPattern("yyyyMM"))
                        + string,
                    DateTimeFormatter.ofPattern("yyyyMMdd").withResolverStyle(
                        ResolverStyle.LENIENT));
            }
            if (Strings2.length(string) == 4) {
                // 月日を4桁で渡した場合
                return LocalDate.parse(
                    DateProvider.currentYear().format(DateTimeFormatter.ofPattern("yyyy")) + string,
                    DateTimeFormatter.ofPattern("yyyyMMdd").withResolverStyle(
                        ResolverStyle.LENIENT));
            }
            if (Strings2.length(string) == 8) {
                // 年月日を6桁で渡した場合
                return LocalDate.parse(string,
                    DateTimeFormatter.ofPattern("yyyyMMdd").withResolverStyle(
                        ResolverStyle.LENIENT));
            }
        }
        if (Strings2.length(string) == 10) {
            // 年月日を10桁（スラッシュ区切りまたはハイフン区切り）で渡した場合
            return LocalDate.parse(Strings2.replace(string, "/", "-"),
                DateTimeFormatter.ISO_LOCAL_DATE.withResolverStyle(
                    ResolverStyle.LENIENT));
        }

        throw new IllegalArgumentException("引数は10桁または8桁,4桁,あるいは2桁でなければなりません 引数:" + string);


    }

}
