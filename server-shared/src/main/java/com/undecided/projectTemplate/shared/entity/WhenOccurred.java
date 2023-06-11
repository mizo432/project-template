package com.undecided.projectTemplate.shared.entity;

import com.undecided.primitive.object.Objects2;
import com.undecided.projectTemplate.shared.value.AbstractDateTimeValue;
import lombok.Getter;
import org.seasar.doma.Domain;

import java.time.LocalDateTime;

/**
 *
 */
@Getter
@Domain(valueType = LocalDateTime.class, factoryMethod = "reconstruct")
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
