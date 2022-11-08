package org.venusPj.projectTemplate.modules.resource.domain.product.attribute;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ProductAttribute {

    private final ProductName name;
    private final ProductCode code;
    private final StoryCodePrefix storyCodePrefix;

    public static ProductAttribute create(ProductName name, ProductCode code,
        StoryCodePrefix storyCodePrefix) {
        return new ProductAttribute(name, code, storyCodePrefix);
    }
}
