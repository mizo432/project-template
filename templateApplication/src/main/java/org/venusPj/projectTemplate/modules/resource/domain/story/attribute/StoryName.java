package org.venusPj.projectTemplate.modules.resource.domain.story.attribute;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.value.StringValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class StoryName implements StringValue<StoryName> {

    private final String value;

    public static StoryName reconstruct(String value) {
        return new StoryName((value));
    }

    @Override
    public String asString() {
        return value;
    }
}
