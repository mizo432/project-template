package org.venusPj.projectTemplate.modules.resource.domain.partyRole.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends AbstractEntity<UserId, User> {

    private final UserAttribute attribute;

    protected User(UserId id, AuditInfo auditInfo, UserAttribute attribute) {
        super(id, auditInfo);
        this.attribute = attribute;

    }

    public static User create(UserAttribute attribute) {
        return new User(UserId.newInstance(), AuditInfo.empty(), attribute);

    }

    public static User create(User project) {
        return new User(UserId.newInstance(), AuditInfo.empty(), project.attribute);

    }

    @Override
    public boolean sameValueAs(User other) {
        return super.sameValueAs(other)
            && attribute.equals(other.attribute);

    }

}
