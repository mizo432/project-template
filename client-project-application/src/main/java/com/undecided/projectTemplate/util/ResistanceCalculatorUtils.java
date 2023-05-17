package com.undecided.projectTemplate.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ResistanceCalculatorUtils {

    public static double parallel(double r1, double r2) {
        return (r1 * r2) / (r1 + r2);
    }
}
