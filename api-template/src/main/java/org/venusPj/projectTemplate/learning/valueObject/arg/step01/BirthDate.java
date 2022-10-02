package org.venusPj.projectTemplate.learning.valueObject.arg.step01;

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
}
