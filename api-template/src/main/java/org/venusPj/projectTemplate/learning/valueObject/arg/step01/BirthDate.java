package org.venusPj.projectTemplate.learning.valueObject.arg.step01;

import java.time.LocalDate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

public class BirthDate {

    private final LocalDate value;


    @VisibleForTesting
    BirthDate(LocalDate birthDate) {
        this.value = birthDate;
    }

    @NotNull
    public static BirthDate of(@NotNull LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("生年月日は必須です");
        }
        return new BirthDate(birthDate);
    }

    @Nullable
    public LocalDate asLocalDate() {
        return value;
    }
}
