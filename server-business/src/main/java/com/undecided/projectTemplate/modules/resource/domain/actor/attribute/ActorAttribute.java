package com.undecided.projectTemplate.modules.resource.domain.actor.attribute;

import com.undecided.projectTemplate.modules.resource.domain.story.attribute.Description;
import com.undecided.projectTemplate.shared.value.name.Name;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ActorAttribute {

    private Name name;
    private Description description;

    public static ActorAttribute reconstruct(String name, String description) {
        return reconstruct(Name.reconstruct(name), Description.reconstruct(description));
    }

    public static ActorAttribute reconstruct(Name name, Description description) {
        return new ActorAttribute(name, description);

    }

    public static ActorAttribute empty() {
        return new ActorAttribute(Name.empty(), Description.empty());
    }
}
