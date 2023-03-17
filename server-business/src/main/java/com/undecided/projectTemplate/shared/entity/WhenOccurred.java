package com.undecided.projectTemplate.shared.entity;

import com.undecided.primitive.object.Objects2;
import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.DateTimeValue;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 *
 */
@Getter
@AllArgsConstructor
@ToString
public class WhenOccurred extends AbstractValue<LocalDateTime> implements
    DateTimeValue<WhenOccurred> {

    private final LocalDateTime value;

    public static WhenOccurred reconstruct(LocalDateTime value) {
        return new WhenOccurred(value);

    }

    @Override
    public String asString() {
        return Objects2.ifPresent(value, Object::toString);
    }
}
