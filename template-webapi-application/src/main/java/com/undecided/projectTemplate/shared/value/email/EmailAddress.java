package com.undecided.projectTemplate.shared.value.email;

import com.undecided.projectTemplate.shared.value.StringValue;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class EmailAddress implements StringValue<EmailAddress> {

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String asString() {
        return value;
    }

    public static EmailAddress of(String value) {
        return new EmailAddress(value);

    }

    public static EmailAddress reconstruct(String value) {
        return new EmailAddress(value);

    }
}
