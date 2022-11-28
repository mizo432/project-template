package org.venusPj.projectTemplate.shared.value.email;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.value.StringValue;

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
