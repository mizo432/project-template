package com.undecided.projectTemplate.resource.domain.story.estimate.velocity;

import com.undecided.projectTemplate.shared.value.Value;
import java.math.BigDecimal;

/**
 * １日あたりの速度
 */
public class VelocityOfDay implements
    Value {

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

    public BigDecimal getValue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return effort.isEmpty() && days.isEmpty();
    }


}
