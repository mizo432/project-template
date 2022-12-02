package org.venusPj.projectTemplate.modules.resource.domain.partyRole.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends AbstractEntity<User> {

    private final UserAttribute attribute;

    protected User(Identifier<User> id, AuditInfo auditInfo, UserAttribute attribute) {
        super(id, auditInfo);
        this.attribute = attribute;

    }

    public static User create(UserAttribute attribute) {
        return new User(Identifier.newInstance(), AuditInfo.empty(), attribute);

    }

    public static User create(User project) {
        return new User(Identifier.newInstance(), AuditInfo.empty(), project.attribute);

    }

    @Override
    public boolean sameValueAs(User other) {
        return super.sameValueAs(other)
            && attribute.equals(other.attribute);

    }

}
