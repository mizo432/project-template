package org.venusPj.projectTemplate.modules.resource.usecase.command;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venusPj.projectTemplate.modules.resource.domain.product.Product;

@Service
@Transactional
public class RegisterProductCommand {

    public Product register(Product product) {
        return Product.create(product);
    }
}
