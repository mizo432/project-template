package org.venusPj.projectTemplate.modules.resource.domain.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;
import org.venusPj.projectTemplate.shared.entity.id.Id;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class ProductResource<I extends Id<I>, E extends ProductResource<I, E>> extends
    AbstractEntity<I, E> {

    private final ProductId productId;


    protected ProductResource(I id, AuditInfo auditInfo, ProductId productId) {
        super(id, auditInfo);
        this.productId = productId;
    }

    @Override
    protected boolean sameValueAs(E other) {
        return super.sameValueAs(other) &&
            productId.equals(other.getProductId());
    }
}
