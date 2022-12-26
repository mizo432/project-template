package com.undecided.projectTemplate.shared.value.name;

import static org.venusPj.primitive.string.Strings2.isEmpty;

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
public class Name implements StringValue<Name> {

    private static final Name EMPTY = new Name(null);
    private final String value;

    public static Name of(String value) {
        if (isEmpty(value)) {
            return EMPTY;
        }

        return new Name(value);

    }

    public static Name reconstruct(String value) {
        if (isEmpty(value)) {
            return EMPTY;
        }
        return new Name(value);

    }

    @Override
    public String asString() {
        return value;

    }

}
