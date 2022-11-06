package org.venusPj.projectTemplate.modules.resource.domain.product;

import de.huxhorn.sulky.ulid.ULID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.id.Id;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class ProductId extends Id<ProductId> {

    private final String value;

    public static ProductId newInstance() {
        return new ProductId(new ULID().nextValue().toString());

    }

    public static ProductId reconstruct(String value) {
        return new ProductId(value);
    }


    @Override
    public String asString() {
        return value;

    }
}
