package com.undecided.projectTemplate.shared.entity;

import com.undecided.projectTemplate.modules.resource.domain.partyRole.user.User;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import com.undecided.projectTemplate.shared.value.AbstractLongValue;
import lombok.Getter;
import org.seasar.doma.Domain;

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

    public static WhoNoticed of(SnowflakeId<User> value) {
        return new WhoNoticed(value.getValue());
    }
}
