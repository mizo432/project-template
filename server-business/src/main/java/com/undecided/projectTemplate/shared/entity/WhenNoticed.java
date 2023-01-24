package com.undecided.projectTemplate.shared.entity;

import com.undecided.projectTemplate.shared.value.DateTimeValue;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Embeddable;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Embeddable
public class WhenNoticed implements DateTimeValue<WhenNoticed> {

    private static final WhenNoticed EMPTY = new WhenNoticed(null);
    private final LocalDateTime value;

    public static WhenNoticed reconstruct(LocalDateTime value) {
        return new WhenNoticed(value);

    }

    public static WhenNoticed now() {
        return new WhenNoticed(LocalDateTime.now());

    }

    public static WhenNoticed empty() {
        return EMPTY;
    }
}
