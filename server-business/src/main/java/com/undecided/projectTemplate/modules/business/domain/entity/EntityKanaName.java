package com.undecided.projectTemplate.modules.business.domain.entity;

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

    private final String value;


    public static EntityKanaName of(String value) {
        return new EntityKanaName(value);
        
    }

    public static EntityKanaName reconstruct(String value) {
        return new EntityKanaName(value);

    }

    @Override
    public String asString() {
        return value;
    }

}
