package org.venusPj.projectTemplate.learning.valueObject.arg.step03;

import java.time.LocalDate;

public class AgeComputerUser {

    private final AgeComputer ageComputer;

    public AgeComputerUser() {
        ageComputer = new AgeComputer();
    }

    public void print() {

        System.out.println(
            ageComputer.computeAge2(BirthDate.of(LocalDate.of(1967, 11, 26)),
                LocalDate.of(2022, 9, 27)
            ));

    }


}
