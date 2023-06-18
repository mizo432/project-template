package template.modules.product.domain.model.business.postalAddress;

import lombok.Getter;
import template.shared.value.AbstractStringValue;

@Getter
public class PostalCode extends AbstractStringValue {


    PostalCode(String value) {
        super(value);
    }

    public static PostalCode of(String value) {
        return new PostalCode(value);
    }

}
