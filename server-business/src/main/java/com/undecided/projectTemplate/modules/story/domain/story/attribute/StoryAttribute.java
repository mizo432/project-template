package com.undecided.projectTemplate.modules.story.domain.story.attribute;

import com.undecided.projectTemplate.shared.type.description.Description;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.seasar.doma.Embeddable;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Embeddable
public class StoryAttribute {

    private final StoryCode code;
    private final StoryName name;
    private final Description description;
    private final StoryType type;
    private final StoryStatus status;

    public static StoryAttribute reconstruct(String code, String name, String description,
                                             StoryType type, StoryStatus status) {
        return new StoryAttribute(StoryCode.reconstruct(code),
                StoryName.reconstruct(name), Description.reconstruct(description), type, status);

    }

}
