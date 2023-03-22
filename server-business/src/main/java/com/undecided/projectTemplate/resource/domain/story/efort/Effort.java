package com.undecided.projectTemplate.resource.domain.story.efort;

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
public class Effort extends AbstractValue<Integer> implements IntegerValue<Effort> {

    private final static Effort EMPTY = new Effort(null);

    private final Integer value;

    public static Effort of(Integer value) {
        if (Objects2.isNull(value)) {
            return EMPTY;
        }
        return new Effort(value);
    }

    public static Effort reconstruct(Integer value) {
        if (Objects2.isNull(value)) {
            return EMPTY;
        }
        return new Effort(value);
    }

    @Override
    public String asString() {
        return Objects2.ifPresent(value, Object::toString);
    }
}
