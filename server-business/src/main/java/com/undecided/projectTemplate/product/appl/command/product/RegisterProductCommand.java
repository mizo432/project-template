package com.undecided.projectTemplate.product.appl.command.product;

import com.undecided.projectTemplate.product.domain.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterProductCommand {

    public Product register(Product product) {
        return Product.create(product);
    }

}
