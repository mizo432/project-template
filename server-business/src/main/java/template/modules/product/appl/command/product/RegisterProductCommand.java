package template.modules.product.appl.command.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.product.domain.model.product.Product;

@Service
@Transactional
public class RegisterProductCommand {

    public Product register(Product product) {
        return Product.create(product);
    }

}
