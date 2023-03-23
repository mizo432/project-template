package com.undecided.projectTemplate.business.domain.entity;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.Getter;

@Getter
public class EntityName extends AbstractStringValue {

    private static final EntityName EMPTY = new EntityName();


    public EntityName() {
        super();

    }

    EntityName(String value) {
        super(value);
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


}
