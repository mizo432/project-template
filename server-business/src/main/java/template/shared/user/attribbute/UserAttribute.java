package template.shared.user.attribbute;

import lombok.*;
import template.shared.value.email.EmailAddress;
import template.shared.value.name.Name;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAttribute {

    private UserCode code;

    private EmailAddress emailAddress;

    private Name name;

    public static UserAttribute create(UserCode code, EmailAddress emailAddress, Name name) {
        return new UserAttribute(code, emailAddress, name);
    }

    public static UserAttribute reconstruct(String code, String emailAddress, String name) {
        return new UserAttribute(UserCode.reconstruct(code), EmailAddress.reconstruct(emailAddress),
                Name.reconstruct(name));
    }

    public static UserAttribute reconstruct(UserCode code, EmailAddress emailAddress, Name name) {
        return new UserAttribute(code, emailAddress, name);
    }

}
