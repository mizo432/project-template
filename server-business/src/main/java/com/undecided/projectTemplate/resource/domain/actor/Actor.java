package com.undecided.projectTemplate.resource.domain.actor;

import com.undecided.projectTemplate.resource.domain.actor.attribute.ActorAttribute;
import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.AuditInfo;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@EqualsAndHashCode
@ToString
public class Actor {

    private final SnowflakeIdentifier<Actor> id;
    private final AuditInfo auditInfo;

    private final SnowflakeIdentifier<Project> projectId;
    private final ActorAttribute attribute;

    private Actor(SnowflakeIdentifier<Actor> id, SnowflakeIdentifier<Project> projectId,
        AuditInfo auditInfo,
        ActorAttribute attribute) {
        this.id = id;
        this.auditInfo = auditInfo;
        this.projectId = projectId;
        this.attribute = attribute;

    }

    public static Actor empty() {
        return new Actor(SnowflakeIdentifier.empty(), SnowflakeIdentifier.empty(),
            AuditInfo.empty(),
            ActorAttribute.empty());
    }

    public boolean sameValueAs(Actor other) {
        return id.equals(other.id) &&
            projectId.equals(other.projectId) &&
            attribute.equals(other.attribute);
    }

    public static Actor reconstruct(@NotNull SnowflakeIdentifier<Actor> id,
        @NotNull AuditInfo auditInfo,
        @NotNull SnowflakeIdentifier<Project> projectId,
        @NotNull ActorAttribute attribute) {
        return new Actor(id, projectId, auditInfo, attribute);

    }

}
