package com.undecided.projectTemplate.story.domain.story.estimate.velocity;

import com.undecided.primitive.object.Objects2;
import com.undecided.projectTemplate.shared.value.AbstractBigDecimalValue;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.undecided.primitive.object.Objects2.isNull;

/**
 * スプリントあたりの速度
 */
@Getter
@ToString
@Domain(valueType = BigDecimal.class, factoryMethod = "reconstruct")
public class VelocityOfSprint extends AbstractBigDecimalValue {

    public static final VelocityOfSprint ZERO = new VelocityOfSprint(BigDecimal.ZERO);
    public static final VelocityOfSprint EMPTY = new VelocityOfSprint(null);

    private VelocityOfSprint(BigDecimal value) {
        super(value);

    }

    public static VelocityOfSprint of(EffortOfSprint effort, DaysOfSprint days) {
        if (effort.isZero()) {
            return VelocityOfSprint.ZERO;
        }
        if (days.isZero()) {
            return EMPTY;
        }

        BigDecimal value = BigDecimal.valueOf(effort.getValue())
                .divide(BigDecimal.valueOf(days.getValue()), 2,
                        RoundingMode.HALF_UP);
        return new VelocityOfSprint(value);


    }

    public static VelocityOfSprint reconstruct(BigDecimal value) {
        if (isNull(value)) {
            return VelocityOfSprint.EMPTY;
        }
        if (BigDecimal.ZERO.equals(value)) {
            return ZERO;
        }
        return new VelocityOfSprint(value);


    }

    @Override
    public String asString() {
        return Objects2.ifPresent(getValue(), BigDecimal::toString);

    }

}
