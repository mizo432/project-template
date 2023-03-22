package com.undecided.projectTemplate.resource.domain.actor;

import com.undecided.projectTemplate.resource.domain.actor.attribute.ActorAttribute;
import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.AbstractEntity;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Actor extends AbstractEntity<Actor> {

    private final UlidIdentifier<Project> projectId;
    private final ActorAttribute attribute;

    private Actor(UlidIdentifier<Actor> id, UlidIdentifier<Project> projectId, AuditInfo auditInfo,
        ActorAttribute attribute) {
        super(id, auditInfo);
        this.projectId = projectId;
        this.attribute = attribute;

    }

    public static Actor empty() {
        return new Actor(UlidIdentifier.empty(), UlidIdentifier.empty(), AuditInfo.empty(),
            ActorAttribute.empty());
    }

    @Override
    public boolean sameValueAs(Actor other) {
        return super.sameValueAs(other) &&
            projectId.equals(other.projectId) &&
            attribute.equals(other.attribute);
    }

    public static Actor reconstruct(@NotNull UlidIdentifier<Actor> id,
        @NotNull UlidIdentifier<Project> projectId,
        @NotNull AuditInfo auditInfo, @NotNull ActorAttribute attribute) {
        return new Actor(id, projectId, auditInfo, attribute);

    }

}
