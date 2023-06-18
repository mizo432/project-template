package template.shared.value.email;

import com.undecided.primitive.string.Strings2;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import template.shared.value.AbstractStringValue;

@Getter
@EqualsAndHashCode(callSuper = false)
public class EmailAddress extends AbstractStringValue {

    private static final EmailAddress EMPTY = new EmailAddress(null);

    public EmailAddress(String value) {
        super(value);

    }

    @Override
    public String asString() {
        return getValue();
    }

    public static EmailAddress of(String value) {

        if (Strings2.isEmpty(value)) {
            return EMPTY;
        }

        return new EmailAddress(value);

    }

    public static EmailAddress reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY;
        }
        return new EmailAddress(value);

    }

}
