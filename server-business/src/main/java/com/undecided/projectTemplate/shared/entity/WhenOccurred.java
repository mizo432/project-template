package com.undecided.projectTemplate.shared.entity;

import com.undecided.primitive.object.Objects2;
import com.undecided.projectTemplate.shared.value.AbstractDateTimeValue;
import java.time.LocalDateTime;
import lombok.Getter;

/**
 *
 */
@Getter
public class WhenOccurred extends AbstractDateTimeValue {


    public WhenOccurred(LocalDateTime value) {
        super(value);
    }

    public static WhenOccurred reconstruct(LocalDateTime value) {
        return new WhenOccurred(value);

    }

    @Override
    public String asString() {
        return Objects2.ifPresent(value, Object::toString);
    }
}
