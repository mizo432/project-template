package com.undecided.projectTemplate.resource.domain.story.estimate.velocity;

import com.undecided.primitive.object.Objects2;
import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.IntegerValue;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class EffortOfSprint extends AbstractValue<Integer> implements IntegerValue<EffortOfSprint> {

    private final Integer value;

    @Override
    public Integer getValue() {
        return value;

    }

    @Override
    public String asString() {
        return Objects2.ifPresent(value, Object::toString);

    }

    public static EffortOfSprint of(Integer value) {
        return new EffortOfSprint(value);

    }

    public static EffortOfSprint reconstruct(Integer value) {
        return new EffortOfSprint(value);
        
    }

    public boolean isZero() {
        return value == null || value.equals(0);
    }
}
