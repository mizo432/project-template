package com.undecided.projectTemplate.shared.entity;

import static com.undecided.primitive.object.Objects2.isNull;

import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.LongValue;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WhoNoticed extends AbstractValue<Long> implements LongValue<WhoNoticed> {

    private static final WhoNoticed EMPTY = new WhoNoticed(null);
    private final Long value;


    public static WhoNoticed reconstruct(Long whoNoticed) {
        if (isNull(whoNoticed)) {
            return EMPTY;
        }
        return new WhoNoticed(whoNoticed);
    }

    public static WhoNoticed empty() {
        return EMPTY;
    }

    @Override
    public String asString() {
        if (isNull(value)) {
            return null;
        }
        return value.toString();
    }

    @Override
    public String toString() {
        if (isNull(value)) {
            return null;
        }
        return value.toString();

    }
    
}
