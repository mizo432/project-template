package com.undecided.projectTemplate.shared.value.name;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.value.AbstractValue;
import com.undecided.projectTemplate.shared.value.StringValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class Name extends AbstractValue<String> implements StringValue<Name> {

    private static final Name EMPTY = new Name(null);
    private final String value;

    public static Name of(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY;
        }

        return new Name(value);

    }

    public static Name reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY;
        }
        return new Name(value);

    }

    public static Name empty() {
        return EMPTY;
    }

    @Override
    public String asString() {
        return value;

    }

}
