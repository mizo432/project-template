package template.shared.entity;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.entity.id.SnowflakeId;
import template.shared.value.AbstractLongValue;

import static com.undecided.primitive.object.Objects2.isNull;

@Getter
@Domain(valueType = Long.class, factoryMethod = "reconstruct")
public class WhoNoticed extends AbstractLongValue {

    private static final WhoNoticed EMPTY = new WhoNoticed(null);

    public WhoNoticed(Long value) {
        super(value);
    }

    public static WhoNoticed reconstruct(Long value) {
        if (isNull(value)) {
            return EMPTY;
        }
        return new WhoNoticed(value);
    }

    public static WhoNoticed empty() {
        return EMPTY;
    }

    public static WhoNoticed of(SnowflakeId value) {
        return new WhoNoticed(value.getValue());
    }
}
