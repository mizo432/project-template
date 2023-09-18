package template.shared.value.name;

import com.undecided.primitive.string.Strings2;
import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class Name extends AbstractStringValue {

    private static final Name EMPTY_VALUE = new Name();

    Name(String value) {
        super(value);
    }

    public Name() {
        super();
    }

    public static Name of(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY_VALUE;
        }

        return new Name(value);

    }

    public static Name reconstruct(String value) {
        if (Strings2.isEmpty(value)) {
            return EMPTY_VALUE;
        }
        return new Name(value);

    }

    public static Name empty() {
        return EMPTY_VALUE;
    }

}
