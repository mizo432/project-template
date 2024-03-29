package template.modules.story.domain.model.estimate.velocity;

import com.undecided.primitive.integers.Integers;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import template.shared.value.AbstractIntegerValue;

/**
 * スプリントの日数
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class DaysOfSprint extends AbstractIntegerValue {

    private final Integer value;

    @Override
    public Integer getValue() {
        return value;

    }

    @Override
    public String asString() {
        return null;
    }

    public static DaysOfSprint of(Integer value) {
        return new DaysOfSprint(value);
    }

    public static DaysOfSprint reconstruct(Integer value) {
        return new DaysOfSprint(value);
    }


    public boolean isZero() {
        return Integers.ZERO.equals(value);

    }
}
