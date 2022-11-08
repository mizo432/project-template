package org.venusPj.projectTemplate.modules.resource.domain.product;

import java.util.List;

public interface ProductRepository {

    Product findOnBy(ProductId productId);

    List<Product> selectAll();

    void insert(Product product);

    void update(Product product);

    void delete(ProductId productId);

}
