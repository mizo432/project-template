package com.undecided.projectTemplate.resource.domain.story.estimate.velocity;

import com.undecided.projectTemplate.shared.value.AbstractBigDecimalValue;
import java.math.BigDecimal;
import lombok.Getter;

/**
 * １日あたりの速度
 */
@Getter
public class VelocityOfDay extends
    AbstractBigDecimalValue {

    VelocityOfDay(BigDecimal value) {
        super(value);
    }

    public static VelocityOfDay create(EffortOfSprint effort, DaysOfSprint days) {
        return new VelocityOfDay(effort.divideBy(days));

    }

    public static VelocityOfDay create(Integer effort, Integer days) {
        return create(EffortOfSprint.of(effort), DaysOfSprint.of(days));

    }


    @Override
    public String asString() {
        return getValue().toString();
        
    }
}
