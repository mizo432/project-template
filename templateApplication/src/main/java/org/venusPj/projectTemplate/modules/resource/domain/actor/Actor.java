package org.venusPj.projectTemplate.modules.resource.domain.actor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.modules.resource.domain.actor.attribute.ActorAttribute;
import org.venusPj.projectTemplate.modules.resource.domain.project.ProjectId;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.responsibility.layer.Layer;
import org.venusPj.projectTemplate.shared.responsibility.layer.LayerType;
import org.venusPj.projectTemplate.shared.responsibility.model.Model;
import org.venusPj.projectTemplate.shared.responsibility.model.ModelType;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Layer(value = LayerType.MODEL_LAYER)
@Model(value = ModelType.PARTY_ROLE)
public class Actor extends AbstractEntity<ActorId, Actor> {

    private final ProjectId projectId;
    private final ActorAttribute attribute;

    private Actor(ActorId id, ProjectId projectId, AuditInfo auditInfo,
        ActorAttribute attribute) {
        super(id, auditInfo);
        this.projectId = projectId;
        this.attribute = attribute;

    }

    @Override
    public boolean sameValueAs(Actor other) {
        return super.sameValueAs(other) &&
            projectId.equals(other.projectId) &&
            attribute.equals(other.attribute);
    }

    public static Actor reconstruct(@NotNull ActorId id, @NotNull ProjectId projectId,
        @NotNull AuditInfo auditInfo, @NotNull ActorAttribute attribute) {
        return new Actor(id, projectId, auditInfo, attribute);

    }

}
