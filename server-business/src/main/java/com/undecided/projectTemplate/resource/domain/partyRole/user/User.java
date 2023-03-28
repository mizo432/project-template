package com.undecided.projectTemplate.resource.domain.partyRole.user;

import static com.undecided.primitive.object.Objects2.isNull;

import com.undecided.projectTemplate.resource.domain.partyRole.user.attribbute.UserAttribute;
import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Id;

@Getter
@EqualsAndHashCode
@ToString
public class User {

    @Id
    protected final SnowflakeIdentifier<User> id;

    protected final AuditInfo auditInfo;

    private final UserAttribute attribute;
    protected final SnowflakeIdentifier<Project> projectId;

    protected User(SnowflakeIdentifier<User> id, AuditInfo auditInfo, UserAttribute attribute,
        SnowflakeIdentifier<Project> projectId) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.attribute = attribute;
        this.projectId = projectId;

    }

    public static User create(UserAttribute attribute, SnowflakeIdentifier<Project> projectId) {
        return new User(SnowflakeIdentifier.newInstance(), AuditInfo.empty(), attribute, projectId);

    }

    public boolean sameValueAs(User other) {
        return sameIdAs(other)
            && attribute.equals(other.attribute)
            && projectId.equals(other.getProjectId());

    }

    private boolean sameIdAs(User other) {
        if (isNull(other)) {
            return false;
        }

        return id.equals(other.getId());

    }

}
