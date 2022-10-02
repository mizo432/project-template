package org.venusPj.projectTemplate.learning.valueObject.arg.step03;

import java.time.LocalDate;
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

    @Nullable
    public LocalDate asLocalDate() {
        return value;
    }

}
