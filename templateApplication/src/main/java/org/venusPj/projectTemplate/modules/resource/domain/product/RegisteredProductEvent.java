package org.venusPj.projectTemplate.modules.resource.domain.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class RegisteredProductEvent extends
    ApplicationEvent {

    private final Product product;

    public RegisteredProductEvent(Object source, Product product) {
        super(source);
        this.product = product;
    }
}
