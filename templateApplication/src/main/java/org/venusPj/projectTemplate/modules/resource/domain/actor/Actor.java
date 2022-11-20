package org.venusPj.projectTemplate.modules.resource.domain.actor;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.venusPj.projectTemplate.modules.resource.domain.actor.attribute.ActorAttribute;
import org.venusPj.projectTemplate.modules.resource.domain.product.ProductId;
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

    private final ProductId productId;
    private final ActorAttribute attribute;

    private Actor(ActorId id, ProductId productId, AuditInfo auditInfo,
        ActorAttribute attribute) {
        super(id, auditInfo);
        this.productId = productId;
        this.attribute = attribute;

    }

    @Override
    public boolean sameValueAs(Actor other) {
        return super.sameValueAs(other) &&
            productId.equals(other.productId) &&
            attribute.equals(other.attribute);
    }

    public static Actor reconstruct(@NotNull ActorId id, @NotNull ProductId productId,
        @NotNull AuditInfo auditInfo, @NotNull ActorAttribute attribute) {
        return new Actor(id, productId, auditInfo, attribute);

    }

}
