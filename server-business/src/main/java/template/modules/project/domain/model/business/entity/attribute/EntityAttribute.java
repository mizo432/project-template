package template.modules.project.domain.model.business.entity.attribute;

import lombok.*;
import org.seasar.doma.Embeddable;
import template.shared.value.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
@Embeddable
public class EntityAttribute implements Value {
    public static EntityAttribute EMPTY_VALUE = new EntityAttribute();
    private final EntityName name;
    private final EntityKanaName kanaName;

    private final EntityType type;

    public EntityAttribute() {
        this(EntityName.EMPTY_VALUE, EntityKanaName.EMPTY_VALUE, EntityType.UNKNOWN);

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
