package template.modules.project.domain.model.business.entity.attribute;

import com.undecided.primitive.string.Strings2;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class EntityKanaName extends AbstractStringValue {

    public static final EntityKanaName EMPTY_VALUE = new EntityKanaName();


    private EntityKanaName(String value) {
        super(value);

    }

    public EntityKanaName() {
        super();
    }


    public static EntityKanaName of(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY_VALUE;
        }
        return new EntityKanaName(value);

    }

    public static EntityKanaName reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY_VALUE;
        }
        return new EntityKanaName(value);

    }

}
