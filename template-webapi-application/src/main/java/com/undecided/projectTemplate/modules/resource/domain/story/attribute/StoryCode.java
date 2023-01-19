package com.undecided.projectTemplate.modules.resource.domain.story.attribute;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import com.undecided.projectTemplate.shared.value.CodeValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class StoryCode implements CodeValue<StoryCode> {

    private final String value;

    public static StoryCode reconstruct(String value) {
        return new StoryCode(value);

    }

    @Override
    public String asString() {
        return value;
    }
}
