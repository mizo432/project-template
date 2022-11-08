package org.venusPj.projectTemplate.modules.resource.domain.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.modules.resource.domain.product.attribute.ProductAttribute;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Product extends AbstractEntity<ProductId, Product> {

    private final ProductAttribute attribute;

    protected Product(ProductId id, AuditInfo auditInfo, ProductAttribute attribute) {
        super(id, auditInfo);
        this.attribute = attribute;

    }

    public static Product create(ProductAttribute attribute) {
        return new Product(ProductId.newInstance(), AuditInfo.empty(), attribute);

    }

    public static Product create(Product product) {
        return new Product(ProductId.newInstance(), AuditInfo.empty(), product.attribute);

    }

    @Override
    public boolean sameValueAs(Product other) {
        return super.sameValueAs(other)
            && attribute.equals(other.attribute);

    }

}
