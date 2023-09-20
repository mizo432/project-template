package template.modules.security.model.user.settingpassword;

import org.seasar.doma.Domain;
import org.springframework.security.crypto.password.PasswordEncoder;
import template.shared.value.AbstractStringValue;


@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class EncodedPassword extends AbstractStringValue {

    public EncodedPassword(final String value) {
        super(value);

    }

    public static EncodedPassword reconstruct(final String value) {
        return new EncodedPassword(value);

    }

    public static EncodedPassword initialize(final PasswordEncoder passwordEncoder) {
        return new EncodedPassword(passwordEncoder.encode("password"));

    }
}
