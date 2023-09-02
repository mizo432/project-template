package template.modules.security.appl.model.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Column;
import org.seasar.doma.Embeddable;
import template.shared.user.attribbute.UserCode;
import template.shared.value.MultiValue;
import template.shared.value.email.EmailAddress;
import template.shared.value.name.Name;

/**
 * ユーザー
 */
@Embeddable
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Getter
public class UserAttribute implements MultiValue<UserAttribute> {

    @Column(name = "user_code")
    private final UserCode userCode;
    @Column(name = "user_code")
    private final Name name;
    @Column(name = "user_code")
    private final Name kanaName;
    @Column(name = "email")
    private final EmailAddress emailAddress;

    public static UserAttribute reconstruct(UserCode userCode, Name name, Name kanaName, EmailAddress emailAddress) {
        return new UserAttribute(userCode, name, kanaName, emailAddress);

    }

    public boolean isEmpty() {
        return userCode.isEmpty() && name.isEmpty() && kanaName.isEmpty() && emailAddress.isEmpty();
    }
}
