package com.undecided.projectTemplate.resource.domain.story.attribute;

import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.Getter;

@Getter
public class StoryName extends AbstractStringValue {


    public StoryName(String value) {
        super(value);
    }

    public static StoryName reconstruct(String value) {
        return new StoryName((value));
    }

}
