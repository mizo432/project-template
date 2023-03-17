package com.undecided.projectTemplate.shared.entity;

import static com.undecided.primitive.object.Objects2.isNull;

import com.undecided.primitive.localDate.StaticDateProvider;
import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.DateTimeValue;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.seasar.doma.Embeddable;

@Getter
@AllArgsConstructor
@Embeddable
public class WhenNoticed extends AbstractValue<LocalDateTime> implements
    DateTimeValue<WhenNoticed> {

    public String asString() {
        if (isNull(getValue())) {
            return null;
        }

        return getValue().toString();
    }

    private static final WhenNoticed EMPTY = new WhenNoticed(null);
    private final LocalDateTime value;

    public static WhenNoticed reconstruct(LocalDateTime value) {
        return new WhenNoticed(value);

    }

    public static WhenNoticed now() {
        return new WhenNoticed(StaticDateProvider.currentLocalDateTime());

    }

    public static WhenNoticed empty() {
        return EMPTY;
    }
}
