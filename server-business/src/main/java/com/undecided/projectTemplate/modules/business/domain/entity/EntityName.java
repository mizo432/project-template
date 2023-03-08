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
public class EntityName implements StringValue<EntityKanaName> {

    private final String value;

    public static EntityName of(String value) {
        return new EntityName(value);
    }

    public static EntityName reconstruct(String value) {
        return new EntityName(value);
    }


    @Override
    public String asString() {
        return value;
    }


}
