package org.venusPj.projectTemplate.shared.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.value.DateTimeValue;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class WhenNoticed implements DateTimeValue<WhenNoticed> {

    private final LocalDateTime value;

    public static WhenNoticed reconstruct(LocalDateTime value) {
        return new WhenNoticed(value);

    }

    public static WhenNoticed now() {
        return new WhenNoticed(LocalDateTime.now());

    }
}
