package com.undecided.projectTemplate.resource.domain.story.attribute;

import com.undecided.projectTemplate.shared.value.StringValue;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class Description implements StringValue<Description>, Serializable {

    private static final Description EMPTY = new Description();

    private final String value;

    private Description() {
        this(null);
    }

    public static Description reconstruct(String value) {
        Description description = new Description(value);
        if (EMPTY.equals(description)) {
            return EMPTY;
        }
        return description;

    }

    public static Description of(String value) {
        return new Description(value);
    }

    public static Description empty() {
        return EMPTY;
    }

    @Override
    public String asString() {
        return value;
    }

}
