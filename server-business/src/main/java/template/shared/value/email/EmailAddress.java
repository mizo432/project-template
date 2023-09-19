package template.shared.value.email;

import com.undecided.primitive.string.Strings2;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

@Getter()
@EqualsAndHashCode(callSuper = false)
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class EmailAddress extends AbstractStringValue {
    /**
     * nullオブジェクト
     */
    public static final EmailAddress EMPTY_VALUE = new EmailAddress();

    EmailAddress(final String value) {
        super(value);

    }

    public EmailAddress() {
        super();
    }

    @Override
    public String asString() {
        return getValue();
    }

    public static EmailAddress of(String value) {

        if (Strings2.isEmpty(value)) {
            return EMPTY_VALUE;
        }

        return new EmailAddress(value);

    }

    public static EmailAddress reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY_VALUE;
        }
        return new EmailAddress(value);

    }

}
