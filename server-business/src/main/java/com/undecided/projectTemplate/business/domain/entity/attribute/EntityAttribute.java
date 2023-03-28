package com.undecided.projectTemplate.business.domain.entity.attribute;

import com.undecided.projectTemplate.shared.value.Value;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Embeddable;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
@Embeddable
public class EntityAttribute implements Value {

    private final EntityName name;
    private final EntityKanaName kanaName;

    private final EntityType type;

    public EntityAttribute() {
        this(EntityName.empty(), EntityKanaName.empty(), EntityType.UNKNOWN);

    }

    public static EntityAttribute empty() {
        return new EntityAttribute();
    }

    @Override
    public boolean isEmpty() {
        return name.isEmpty() && kanaName.isEmpty() && type.equals(EntityType.UNKNOWN);

    }

    public static EntityAttribute reconstruct(String name, String kanaName, EntityType type) {
        return reconstruct(EntityName.reconstruct(name), EntityKanaName.reconstruct(kanaName),
            type);
    }

    private static EntityAttribute reconstruct(EntityName name, EntityKanaName kanaName,
        EntityType type) {
        return new EntityAttribute(name, kanaName, type);
    }


}
