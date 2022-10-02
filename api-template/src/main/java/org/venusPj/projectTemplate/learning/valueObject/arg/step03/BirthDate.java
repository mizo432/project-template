package org.venusPj.projectTemplate.learning.valueObject.arg.step03;

import static org.venusPj.precondition.object.ObjectPrecondition.checkNotNull;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class BirthDate {

    private final LocalDate value;

    @NotNull
    public static BirthDate of(@NotNull LocalDate birthDate) {
        checkNotNull(birthDate,
            () -> new IllegalArgumentException("生年月日は必須です"));

        return new BirthDate(birthDate);
    }

    @Nullable
    public LocalDate asLocalDate() {
        return value;
    }

    int computeBaseAge(@NotNull TargetDate targetDate) {
        return targetDate.asLocalDate().getYear() - asLocalDate().getYear();
    }

    boolean isBeforeDayOfMonth(@NotNull TargetDate targetDate) {
        return targetDate.asLocalDate().getDayOfMonth() < asLocalDate().getDayOfMonth();
    }

    boolean isSameMonth(@NotNull TargetDate targetDate) {
        return targetDate.asLocalDate().getMonth().equals(asLocalDate().getMonth());
    }

    boolean isBeforeMonth(@NotNull TargetDate targetDate) {
        return targetDate.asLocalDate().getMonthValue() < asLocalDate().getMonthValue();
    }

    boolean isAfter(@NotNull TargetDate targetDate) {
        return asLocalDate().isAfter(targetDate.asLocalDate());
    }

    public int computeAge(@NotNull TargetDate targetDate) {
        checkNotNull(this, () ->
            new IllegalArgumentException("生年月日が指定されていません"));
        checkNotNull(targetDate, () ->
            new IllegalArgumentException("対象日付が指定されていません"));

        if (isAfter(targetDate)) {
            throw new IllegalArgumentException("対象年月日が生年月日以前のため年齢を求められません");
        }
        int baseAge = computeBaseAge(targetDate);
        if (isBeforeMonth(targetDate)) {
            return baseAge - 1;
        }
        if (isSameMonth(targetDate) &&
            isBeforeDayOfMonth(targetDate)) {
            return baseAge - 1;
        }

        return baseAge;
    }

}
