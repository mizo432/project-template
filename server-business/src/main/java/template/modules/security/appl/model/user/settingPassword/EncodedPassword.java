package template.modules.security.appl.model.user.settingPassword;

import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;


@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class EncodedPassword extends AbstractStringValue {

    public EncodedPassword(final String value) {
        super(value);

    }

    public static EncodedPassword reconstruct(String value) {
        return new EncodedPassword(value);

    }
}
