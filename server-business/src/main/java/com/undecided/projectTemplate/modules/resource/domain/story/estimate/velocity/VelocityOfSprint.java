package com.undecided.projectTemplate.modules.resource.domain.story.estimate.velocity;

import com.undecided.primitive.object.Objects2;
import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.BigDecimalValue;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * スプリントあたりの速度
 */
@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VelocityOfSprint extends AbstractValue<BigDecimal> implements
    BigDecimalValue<VelocityOfSprint> {

    public static final VelocityOfSprint ZERO = new VelocityOfSprint(BigDecimal.ZERO);
    public static final VelocityOfSprint EMPTY = new VelocityOfSprint(null);
    private final BigDecimal value;

    public static VelocityOfSprint create(EffortOfSprint effort, DaysOfSprint days) {
        if (effort.isZero()) {
            return VelocityOfSprint.ZERO;
        }
        BigDecimal value = BigDecimal.valueOf(effort.getValue())
            .divide(BigDecimal.valueOf(days.getValue()), 2,
                RoundingMode.HALF_UP);
        return new VelocityOfSprint(value);


    }

    @Override
    public String asString() {
        return Objects2.ifPresent(value, BigDecimal::toString);
        
    }
}
