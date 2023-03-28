package com.undecided.projectTemplate.resource.domain.story.attribute;

import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.Getter;
import org.seasar.doma.Domain;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class Description extends AbstractStringValue {

    private static final Description EMPTY = new Description();

    private Description() {
        super();
    }

    Description(String value) {
        super(value);
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
