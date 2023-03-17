package com.undecided.projectTemplate.modules.resource.domain.sprint;

import com.google.common.base.Function;
import com.undecided.primitive.object.Objects2;
import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.IntegerValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class SprintNumber extends AbstractValue<Integer> implements
    IntegerValue<SprintNumber> {

    private final Integer value;

    public static SprintNumber reconstruct(Integer value) {
        return new SprintNumber(value);

    }

    @Override
    public String asString() {
        return Objects2.ifPresent(getValue(),
            (Function<Integer, String>) Object::toString);
        
    }


}
