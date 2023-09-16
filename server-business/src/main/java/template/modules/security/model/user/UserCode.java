package template.modules.security.model.user;

import lombok.NoArgsConstructor;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

@NoArgsConstructor
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class UserCode extends AbstractStringValue {
    UserCode(final String value) {
        super(value);
    }

    public static UserCode of(final String value) {
        return new UserCode(value);
    }

    public static UserCode reconstruct(final String value) {
        return new UserCode(value);
    }
}
