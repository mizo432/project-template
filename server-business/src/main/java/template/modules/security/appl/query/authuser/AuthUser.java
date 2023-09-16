package template.modules.security.appl.query.authuser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import template.modules.security.model.user.User;
import template.modules.security.model.user.settingpassword.EncodedPassword;
import template.shared.value.MultiValue;

@AllArgsConstructor
@Getter
@ToString(exclude = {"encodedPassword"})
public class AuthUser implements MultiValue<AuthUser> {

    private final User user;
    private final EncodedPassword encodedPassword;

    public static AuthUser reconstruct(final User user, final EncodedPassword encodedPassword) {
        return new AuthUser(user, encodedPassword);
    }

    public boolean isEmpty() {
        return user.isEmpty() && encodedPassword.isEmpty();
    }
}
