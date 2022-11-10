package org.venusPj.projectTemplate.shared.value.name;

import static org.venusPj.projectTemplate.shared.primitive.string.Strings2.isEmpty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.value.StringValue;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class Name implements StringValue<Name> {

    private static final Name EMPTY = new Name(null);
    private final String value;

    public static Name of(String value) {
        if (isEmpty(value))
            return EMPTY;

        return new Name(value);

    }

    @Override
    public String asString() {
        return value;

    }

}
