package com.undecided.projectTemplate.modules.story.domain.model.estimate.velocity;

import com.undecided.primitive.integers.Integers;
import com.undecided.projectTemplate.shared.value.AbstractIntegerValue;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

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
