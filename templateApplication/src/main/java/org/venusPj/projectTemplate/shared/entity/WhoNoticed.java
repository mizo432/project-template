package org.venusPj.projectTemplate.shared.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.value.StringValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class WhoNoticed implements StringValue<WhoNoticed> {

    private final String value;

    public static WhoNoticed reconstruct(String whoNoticed) {
        return new WhoNoticed(whoNoticed);
    }
}
