package org.venusPj.projectTemplate.modules.resource.domain.product;

public interface ProductRepository {

    Product findOnBy(ProductId productId);

}
