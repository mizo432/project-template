package com.undecided.projectTemplate.modules.resource.domain.partyRole.user.attribbute;

import com.undecided.projectTemplate.shared.value.email.EmailAddress;
import com.undecided.projectTemplate.shared.value.name.Name;
import lombok.*;

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
