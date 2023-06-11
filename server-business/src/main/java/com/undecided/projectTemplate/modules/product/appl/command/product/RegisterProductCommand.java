package com.undecided.projectTemplate.modules.product.appl.command.product;

import com.undecided.projectTemplate.modules.product.domain.model.product.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterProductCommand {

    public Product register(Product product) {
        return Product.create(product);
    }

}
