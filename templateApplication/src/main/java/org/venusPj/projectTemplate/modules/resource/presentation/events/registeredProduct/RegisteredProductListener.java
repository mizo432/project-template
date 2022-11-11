package org.venusPj.projectTemplate.modules.resource.presentation.events.registeredProduct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.venusPj.projectTemplate.modules.resource.domain.product.Product;
import org.venusPj.projectTemplate.modules.resource.domain.product.RegisteredProductEvent;

@Component
@Slf4j
public class RegisteredProductListener implements ApplicationListener<RegisteredProductEvent> {

    @Override
    public void onApplicationEvent(RegisteredProductEvent event) {
        Product product = event.getProduct();
        log.debug("regstered " + product);

    }

}