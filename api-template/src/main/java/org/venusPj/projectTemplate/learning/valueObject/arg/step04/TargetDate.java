package org.venusPj.projectTemplate.learning.valueObject.arg.step04;

import java.time.LocalDate;
import java.time.Month;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import org.venusPj.precondition.object.ObjectPrecondition;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class TargetDate {

    private final LocalDate value;

    public static TargetDate of(LocalDate targetDate) {
        ObjectPrecondition.checkNotNull(targetDate, () ->
            new IllegalArgumentException("対象日付が指定されていません"));

        return new TargetDate(targetDate);
    }

    Month getMonth() {
        return value.getMonth();
    }

    int getYear() {
        return value.getYear();
    }

    @Nullable
    public LocalDate asLocalDate() {
        return value;
    }

    int getDayOfMonth() {
        return value.getDayOfMonth();

    }
}
