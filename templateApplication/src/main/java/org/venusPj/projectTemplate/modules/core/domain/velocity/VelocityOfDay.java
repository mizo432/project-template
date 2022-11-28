package org.venusPj.projectTemplate.modules.core.domain.velocity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.venusPj.projectTemplate.shared.value.BigDecimalValue;

/**
 * １日あたりの速度
 */
public class VelocityOfDay implements BigDecimalValue<VelocityOfDay> {

    private final EffortOfSprint effort;
    private final DaysOfSprint days;

    VelocityOfDay(EffortOfSprint effort, DaysOfSprint days) {
        this.effort = effort;
        this.days = days;

    }

    public static VelocityOfDay create(EffortOfSprint effort, DaysOfSprint days) {
        return new VelocityOfDay(effort, days);

    }

    public static VelocityOfDay create(Integer effort, Integer days) {
        return create(EffortOfSprint.of(effort), DaysOfSprint.of(days));

    }

    @Override
    public BigDecimal getValue() {
        if (effort.isZero()) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(effort.getValue()).divide(BigDecimal.valueOf(days.getValue()), 2,
            RoundingMode.HALF_UP);
    }
}
