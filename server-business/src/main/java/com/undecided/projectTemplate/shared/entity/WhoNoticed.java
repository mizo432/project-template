package com.undecided.projectTemplate.shared.entity;

import static com.undecided.primitive.object.Objects2.isNull;

import com.undecided.projectTemplate.shared.value.AbstractLongValue;
import lombok.Getter;

@Getter
public class WhoNoticed extends AbstractLongValue {

    private static final WhoNoticed EMPTY = new WhoNoticed(null);

    public WhoNoticed(Long value) {
        super(value);
    }

    public static WhoNoticed reconstruct(Long value) {
        if (isNull(value)) {
            return EMPTY;
        }
        return new WhoNoticed(value);
    }

    public static WhoNoticed empty() {
        return EMPTY;
    }

}
