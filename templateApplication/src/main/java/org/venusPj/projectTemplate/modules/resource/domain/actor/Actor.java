package org.venusPj.projectTemplate.modules.resource.domain.actor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.modules.resource.domain.actor.attribute.ActorAttribute;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;
import org.venusPj.projectTemplate.shared.responsibility.layer.Layer;
import org.venusPj.projectTemplate.shared.responsibility.layer.LayerType;
import org.venusPj.projectTemplate.shared.responsibility.model.Model;
import org.venusPj.projectTemplate.shared.responsibility.model.ModelType;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Layer(value = LayerType.MODEL_LAYER)
@Model(value = ModelType.PARTY_ROLE)
public class Actor extends AbstractEntity<Actor> {

    private final Identifier<Project> projectId;
    private final ActorAttribute attribute;

    private Actor(Identifier<Actor> id, Identifier<Project> projectId, AuditInfo auditInfo,
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

    public static Actor reconstruct(@NotNull Identifier<Actor> id,
        @NotNull Identifier<Project> projectId,
        @NotNull AuditInfo auditInfo, @NotNull ActorAttribute attribute) {
        return new Actor(id, projectId, auditInfo, attribute);

    }

}
