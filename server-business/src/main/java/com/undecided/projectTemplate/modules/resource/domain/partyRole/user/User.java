package com.undecided.projectTemplate.modules.resource.domain.partyRole.user;

import com.undecided.projectTemplate.modules.project.domain.model.project.Project;
import com.undecided.projectTemplate.modules.resource.domain.partyRole.user.attribbute.UserAttribute;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Id;

import static com.undecided.primitive.object.Objects2.isNull;

@Getter
@EqualsAndHashCode
@ToString
public class User {

    @Id
    protected final SnowflakeId<User> id;

    protected final AuditInfo auditInfo;

    private final UserAttribute attribute;
    protected final SnowflakeId<Project> projectId;

    protected User(SnowflakeId<User> id, AuditInfo auditInfo, UserAttribute attribute,
                   SnowflakeId<Project> projectId) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.attribute = attribute;
        this.projectId = projectId;

    }

    public static User create(UserAttribute attribute, SnowflakeId<Project> projectId) {
        return new User(SnowflakeId.newInstance(), AuditInfo.empty(), attribute, projectId);

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
