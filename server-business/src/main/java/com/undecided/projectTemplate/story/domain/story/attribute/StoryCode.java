package com.undecided.projectTemplate.story.domain.story.attribute;

import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import com.undecided.projectTemplate.shared.value.CodeValue;
import lombok.Getter;
import org.seasar.doma.Domain;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class StoryCode extends AbstractStringValue implements CodeValue {


    StoryCode(String value) {
        super(value);
    }

    public static StoryCode reconstruct(String value) {
        return new StoryCode(value);

    }

}
