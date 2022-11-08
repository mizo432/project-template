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
public class ProductName implements StringValue<ProductName> {

    private final String value;


    @Override
    public String asString() {
        return value;
    }

    public static ProductName of(String value) {
        StringPreconditions.checkNotEmpty(value, "プロダクト名");
        return new ProductName(value);

    }

    public static ProductName reconstruct(String value) {
        return new ProductName(value);


    }
}
