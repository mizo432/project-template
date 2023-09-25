package template.modules.project.domain.model.business.entity.attribute;

import com.undecided.primitive.string.Strings2;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class EntityName extends AbstractStringValue {

    public static final EntityName EMPTY_VALUE = new EntityName();


    public EntityName() {
        super();

    }

    EntityName(String value) {
        super(value);
    }

    public static EntityName of(String value) {
        if (Strings2.isEmpty(value)) {
            return EntityName.EMPTY_VALUE;
        }

        return new EntityName(value);
    }

    public static EntityName reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return EntityName.EMPTY_VALUE;
        }

        return new EntityName(value);
    }


}
