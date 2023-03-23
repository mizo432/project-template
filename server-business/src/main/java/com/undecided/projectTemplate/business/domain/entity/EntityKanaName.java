package com.undecided.projectTemplate.business.domain.entity;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class EntityKanaName extends AbstractStringValue {

    private static final EntityKanaName EMPTY = new EntityKanaName();


    private EntityKanaName(String value) {
        super(value);

    }

    public EntityKanaName() {
        super();
    }


    public static EntityKanaName of(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY;
        }
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

}
