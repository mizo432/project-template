package com.undecided.projectTemplate.business.domain.entity;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.value.StringValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class EntityKanaName implements StringValue<EntityKanaName> {

    private static final EntityKanaName EMPTY = new EntityKanaName();

    private final String value;

    public EntityKanaName() {
        this.value = null;
    }


    public static EntityKanaName of(String value) {
        return new EntityKanaName(value);

    }

    public static EntityKanaName reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY;
        }
        return new EntityKanaName(value);

    }

    public static EntityKanaName empty() {
        return EMPTY;

    }

    @Override
    public String asString() {
        return value;
    }

}
