package org.venusPj.projectTemplate.shared.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.value.DateTimeValue;

/**
 *
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class WhenOccurred implements DateTimeValue<WhenOccurred> {

    private final LocalDateTime value;

    public static WhenOccurred reconstruct(LocalDateTime value) {
        return new WhenOccurred(value);

    }

}
