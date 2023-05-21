package com.undecided.projectTemplate.sprint.domain.sprint;

import com.google.common.base.Function;
import com.undecided.primitive.object.Objects2;
import com.undecided.projectTemplate.shared.value.AbstractIntegerValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class SprintNumber extends AbstractIntegerValue {

    SprintNumber(Integer value) {
        super(value);
    }

    public static SprintNumber reconstruct(Integer value) {
        return new SprintNumber(value);

    }

    @Override
    public String asString() {
        return Objects2.ifPresent(getValue(),
                (Function<Integer, String>) Object::toString);

    }

}
