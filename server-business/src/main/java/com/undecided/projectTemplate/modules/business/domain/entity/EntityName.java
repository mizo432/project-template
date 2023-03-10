package com.undecided.projectTemplate.modules.business.domain.entity;

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
public class EntityName implements StringValue<EntityKanaName> {

    private static final EntityName EMPTY = new EntityName();

    private final String value;

    public EntityName() {
        value = null;
        
    }

    public static EntityName of(String value) {
        if (Strings2.isEmpty(value)) {
            return EntityName.EMPTY;
        }

        return new EntityName(value);
    }

    public static EntityName reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return EntityName.EMPTY;
        }

        return new EntityName(value);
    }

    public static EntityName empty() {
        return EMPTY;
    }


    @Override
    public String asString() {
        return value;
    }


}
