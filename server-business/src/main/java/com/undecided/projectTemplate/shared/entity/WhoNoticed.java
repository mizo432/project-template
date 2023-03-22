package com.undecided.projectTemplate.shared.entity;

import static com.undecided.primitive.object.Objects2.isNull;

import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.StringValue;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class WhoNoticed extends AbstractValue<String> implements StringValue<WhoNoticed> {

    private static final WhoNoticed EMPTY = new WhoNoticed(null);
    private final String value;


    public static WhoNoticed reconstruct(String whoNoticed) {
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
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
