package com.undecided.projectTemplate.shared.entity;

import com.undecided.primitive.localDate.StaticDateProvider;
import com.undecided.projectTemplate.shared.value.AbstractDateTimeValue;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class WhenNoticed extends AbstractDateTimeValue {

    private static final WhenNoticed EMPTY = new WhenNoticed(null);

    WhenNoticed(LocalDateTime value) {
        super(value);
    }

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
