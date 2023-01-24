package com.undecided.projectTemplate.modules.resource.domain.actor;

import com.undecided.projectTemplate.modules.resource.domain.actor.attribute.ActorAttribute;
import com.undecided.projectTemplate.modules.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.Identifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Actor extends AbstractEntity<Actor> {

    private final Identifier<Project> projectId;
    private final ActorAttribute attribute;

    private Actor(Identifier<Actor> id, Identifier<Project> projectId, AuditInfo auditInfo,
        ActorAttribute attribute) {
        super(id, auditInfo);
        this.projectId = projectId;
        this.attribute = attribute;

    }

    public static Actor empty() {
        return new Actor(Identifier.empty(), Identifier.empty(), AuditInfo.empty(),
            ActorAttribute.empty());
    }

    @Override
    public boolean sameValueAs(Actor other) {
        return super.sameValueAs(other) &&
            projectId.equals(other.projectId) &&
            attribute.equals(other.attribute);
    }

    public static Actor reconstruct(@NotNull Identifier<Actor> id,
        @NotNull Identifier<Project> projectId,
        @NotNull AuditInfo auditInfo, @NotNull ActorAttribute attribute) {
        return new Actor(id, projectId, auditInfo, attribute);

    }

}
