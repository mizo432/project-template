package com.undecided.projectTemplate.shared.responsibility;


import static org.venusPj.primitive.string.Strings2.isEmpty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class Responsibility {

    private static final Responsibility EMPTY = new Responsibility(null);

    private final String value;

    public static Responsibility of(String value) {
        if (isEmpty(value)) {
            return EMPTY;
        }
        return new Responsibility(value);
    }

}
