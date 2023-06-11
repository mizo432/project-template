package com.undecided.projectTemplate.story.domain.story.attribute;

import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.Getter;
import org.seasar.doma.Domain;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class StoryName extends AbstractStringValue {


    public StoryName(String value) {
        super(value);
    }

    public static StoryName reconstruct(String value) {
        return new StoryName((value));
    }

}
