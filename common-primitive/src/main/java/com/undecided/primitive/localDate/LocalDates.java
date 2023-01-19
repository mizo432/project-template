package com.undecided.primitive.localDate;

import com.undecided.primitive.object.Objects2;
import com.undecided.primitive.string.Strings2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public class LocalDates {

    public static LocalDate tryToParse(@NotNull String string) {
        checkNotNull(string, "string");
        checkNotEmpty(string, "string");
        if (Strings2.length(string) <= 8) {
            checkAllCharactersAreDigits(string, () -> new IllegalArgumentException(
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

    private static <T> void checkNotNull(@NotNull T reference, @NotNull String label) {
        if (Objects2.isNull(label)) {
            throw new IllegalArgumentException("引数のlabelは必須ですが指定されていません");

        }
        if (Strings2.isEmpty(label)) {
            throw new IllegalArgumentException("引数のlabelは必須ですが指定されていません");
        }
        checkNotNull(reference, () -> new IllegalArgumentException(label + "は必須です"));

    }

    private static <T, RE extends RuntimeException> void checkNotNull(@NotNull T reference,
        @NotNull Supplier<RE> exceptionSupplier) {
        if (Objects2.isNull(exceptionSupplier)) {
            throw new IllegalArgumentException("引数の\"exceptionSupplier\"は必須ですが指定されていません");
        }

        if (Objects2.isNull(reference)) {
            throw exceptionSupplier.get();
        }
    }

    private static void checkNotEmpty(@NotNull String reference, @NotNull String label) {
        if (Strings2.isEmpty(label)) {
            throw new IllegalArgumentException(
                "引数のlabelが空白です。引数のlabelに空白は許容されません。");
        }

        checkNotNull(reference, label);
        if (Strings2.isEmpty(reference)) {
            throw new IllegalArgumentException(
                label + "が空白です。" + label + "に空白は許容されません。");
        }

    }

    /**
     * 参照値の全ての文字が10進数字である事をチェックします。
     *
     * @param reference                参照値
     * @param runtimeExceptionSupplier 参照値が対象値セットが含まれていない場合返す例外の供給者を指定します。
     */
    private static void checkAllCharactersAreDigits(@NotNull String reference,
        Supplier<RuntimeException> runtimeExceptionSupplier) {
        checkNotNull(reference, "referenceString");
        if (!Strings2.isDigit(reference)) {
            throw runtimeExceptionSupplier.get();
        }

    }

}
