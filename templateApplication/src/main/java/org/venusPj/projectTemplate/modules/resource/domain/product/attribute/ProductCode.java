package org.venusPj.projectTemplate.modules.resource.domain.product.attribute;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions;
import org.venusPj.projectTemplate.shared.value.StringValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class ProductCode implements StringValue<ProductCode> {

    private final String value;


    @Override
    public String asString() {
        return value;
    }

    public static ProductCode of(String value) {
        StringPreconditions.checkNotEmpty(value, "プロダクトコード");
        return new ProductCode(value);

    }

    public static ProductCode reconstruct(String value) {
        return new ProductCode(value);


    }
}
