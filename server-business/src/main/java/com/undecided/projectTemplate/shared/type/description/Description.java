package com.undecided.projectTemplate.shared.type.description;

import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.Getter;
import org.seasar.doma.Domain;

import static com.undecided.primitive.string.Strings2.ifIsEmptyToNull;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class Description extends AbstractStringValue {

    private static final Description EMPTY = new Description();

    private Description() {
        super();
    }

    Description(String value) {
        super(ifIsEmptyToNull(value));
    }

    public static Description reconstruct(String value) {
        Description description = new Description(value);
        if (EMPTY.equals(description)) {
            return EMPTY;
        }
        return description;

    }

    public static Description of(String value) {
        return new Description(value);
    }

    public static Description empty() {
        return EMPTY;
    }


}
