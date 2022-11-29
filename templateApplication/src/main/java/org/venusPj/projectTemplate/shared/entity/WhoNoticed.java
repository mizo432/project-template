package org.venusPj.projectTemplate.shared.entity;

import static org.venusPj.primitive.object.Objects2.isNull;

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

    private static final WhoNoticed EMPTY = new WhoNoticed(null);
    private final String value;


    public static WhoNoticed reconstruct(String whoNoticed) {
        if (isNull(whoNoticed)) {
            return EMPTY;
        }
        return new WhoNoticed(whoNoticed);
    }

    public static WhoNoticed empty() {
        return EMPTY;
    }

    @Override
    public String asString() {
        return value;
    }
}
