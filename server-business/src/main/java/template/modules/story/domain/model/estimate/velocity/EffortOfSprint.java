package template.modules.story.domain.model.estimate.velocity;

import com.undecided.primitive.object.Objects2;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import template.shared.value.AbstractIntegerValue;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class EffortOfSprint extends AbstractIntegerValue {


    EffortOfSprint(Integer value) {
        super(value);
    }

    @Override
    public String asString() {
        return Objects2.ifPresent(getValue(), Object::toString);

    }

    public static EffortOfSprint of(Integer value) {
        return new EffortOfSprint(value);

    }

    public static EffortOfSprint reconstruct(Integer value) {
        return new EffortOfSprint(value);

    }

    public boolean isZero() {
        return getValue() == null || getValue().equals(0);

    }

    public BigDecimal divideBy(DaysOfSprint days) {
        return BigDecimal.valueOf(getValue() / days.getValue());

    }
}
