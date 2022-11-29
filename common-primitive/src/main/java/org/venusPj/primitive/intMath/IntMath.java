package org.venusPj.primitive.intMath;

import static java.lang.Math.abs;
import static java.math.RoundingMode.HALF_EVEN;
import static java.math.RoundingMode.HALF_UP;
import static org.venusPj.primitive.object.Objects2.isNull;

import java.math.RoundingMode;
import org.jetbrains.annotations.NotNull;

public class IntMath {

    public static int divide(int p, int q, RoundingMode roundingMode) {
        checkNotNull(roundingMode, "roundingMode");
        if (q == 0) {
            throw new ArithmeticException("/ by zero"); // for GWT
        }
        int div = p / q;
        int rem = p - q * div; // equal to p % q

        if (rem == 0) {
            return div;
        }
        int signum = 1 | ((p ^ q) >> (Integer.SIZE - 1));
        boolean increment;
        switch (roundingMode) {
            case DOWN -> increment = false;
            case UP -> increment = true;
            case CEILING -> increment = signum > 0;
            case FLOOR -> increment = signum < 0;
            case HALF_EVEN, HALF_DOWN, HALF_UP -> {
                int absRem = abs(rem);
                int cmpRemToHalfDivisor = absRem - (abs(q) - absRem);
                if (cmpRemToHalfDivisor == 0) {
                    increment = (roundingMode == HALF_UP || (roundingMode == HALF_EVEN
                        & (div & 1) != 0));
                } else {
                    increment = cmpRemToHalfDivisor > 0; // closer to the UP value
                }
            }
            case UNNECESSARY -> throw new IllegalArgumentException("modeの指定でUNNECESSARYは誤っています");
            default -> throw new IllegalArgumentException("modeの指定が誤っています");
        }
        return increment ? div + signum : div;
    }

    private static void checkNotNull(@NotNull Object referance, @NotNull String label) {
        if (isNull(referance)) {
            throw new IllegalArgumentException("引数" + label + "がnullです");
        }
    }


}
