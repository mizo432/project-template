package template.modules.project.domain.model.business.postaladdress;

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
