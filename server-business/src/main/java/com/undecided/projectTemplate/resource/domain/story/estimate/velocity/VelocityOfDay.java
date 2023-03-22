package com.undecided.projectTemplate.resource.domain.story.estimate.velocity;

import static com.undecided.primitive.object.Objects2.isNull;

import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.BigDecimalValue;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * １日あたりの速度
 */
public class VelocityOfDay extends AbstractValue<BigDecimal> implements
    BigDecimalValue<VelocityOfDay> {

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

    @Override
    public String asString() {
        if (isNull(getValue())) {
            return null;
        }
        return getValue().toString();
    }

    @Override
    public boolean isEmpty() {
        return effort.isEmpty() && days.isEmpty();
    }
}
