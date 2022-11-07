package org.venusPj.projectTemplate.modules.resource.domain.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.AbstractEntity;
import org.venusPj.projectTemplate.shared.entity.AuditInfo;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Product extends AbstractEntity<ProductId, Product> {

    private final ProductName name;

    private final StoryCodePrefix storyCodePrefix;

    protected Product(ProductId id, AuditInfo auditInfo, ProductName name,
        StoryCodePrefix storyCodePrefix) {
        super(id, auditInfo);
        this.name = name;
        this.storyCodePrefix = storyCodePrefix;
    }

    public static Product create(String name, String storyCodePrefix) {
        return create(ProductName.of(name), StoryCodePrefix.of(storyCodePrefix));

    }

    public static Product create(ProductName name, StoryCodePrefix storyCodePrefix) {
        return new Product(ProductId.newInstance(), AuditInfo.empty(), name, storyCodePrefix);

    }

    public static Product create(Product product) {
        return new Product(ProductId.newInstance(), AuditInfo.empty(), product.getName(),
            product.getStoryCodePrefix());

    }

    @Override
    public boolean sameValueAs(Product other) {
        return super.sameValueAs(other)
            && name.equals(other.name)
            && storyCodePrefix.equals(other.storyCodePrefix);

    }

}
