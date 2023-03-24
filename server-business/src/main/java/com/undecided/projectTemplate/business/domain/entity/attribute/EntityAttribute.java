package com.undecided.projectTemplate.business.domain.entity.attribute;

import com.undecided.projectTemplate.business.domain.entity.EntityKanaName;
import com.undecided.projectTemplate.business.domain.entity.EntityName;
import com.undecided.projectTemplate.business.domain.entity.EntityType;
import com.undecided.projectTemplate.shared.value.Value;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class EntityAttribute implements Value {

    private final EntityName name;
    private final EntityKanaName kanaName;

    private final EntityType type;

    @Override
    public boolean isEmpty() {
        return name.isEmpty() && kanaName.isEmpty() && type.equals(EntityType.UNKNOWN);

    }

    public static EntityAttribute reconstruct(String name, String kanaName, EntityType type) {
        return reconstruct(EntityName.reconstruct(name), EntityKanaName.reconstruct(kanaName),
            type);
    }

    private static EntityAttribute reconstruct(EntityName name, EntityKanaName kanaName,
        com.undecided.projectTemplate.business.domain.entity.EntityType type) {
        return new EntityAttribute(name, kanaName, type);
    }


}
