package com.undecided.projectTemplate.modules.story.domain.model.efort;

import com.undecided.primitive.object.Objects2;
import com.undecided.projectTemplate.shared.value.AbstractIntegerValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Effort extends AbstractIntegerValue {

    private final static Effort EMPTY = new Effort(null);

    Effort(Integer value) {
        super(value);
    }


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
        return Objects2.ifPresent(getValue(), Object::toString);
    }
}
