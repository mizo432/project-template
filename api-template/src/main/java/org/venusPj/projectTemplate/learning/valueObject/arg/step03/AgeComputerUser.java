package org.venusPj.projectTemplate.learning.valueObject.arg.step03;

import java.time.LocalDate;
import org.jetbrains.annotations.NotNull;
import org.venusPj.precondition.object.ObjectPrecondition;

public class AgeComputerUser {

    private final AgeComputer ageComputer;

    public AgeComputerUser() {
        ageComputer = new AgeComputer();
    }

    public void print() {

        @NotNull BirthDate birthDate = BirthDate.of(LocalDate.of(1967, 11, 26));
        @NotNull LocalDate tTargetDate = LocalDate.of(2022, 9, 27);
        ObjectPrecondition.checkNotNull(birthDate, () ->
            new IllegalArgumentException("生年月日が指定されていません"));
        ObjectPrecondition.checkNotNull(tTargetDate, () ->
            new IllegalArgumentException("対象日付が指定されていません"));

        TargetDate targetDate = TargetDate.of(tTargetDate);

        System.out.println(
            birthDate.computeAge(targetDate));

    }


}
