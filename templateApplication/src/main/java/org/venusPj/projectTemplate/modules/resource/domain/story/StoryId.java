package org.venusPj.projectTemplate.modules.resource.domain.story;

import de.huxhorn.sulky.ulid.ULID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.entity.id.Id;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class StoryId extends Id<StoryId> {

    private final String value;

    public static StoryId newInstance() {
        return new StoryId(new ULID().nextValue().toString());

    }

    public static StoryId reconstruct(String value) {
        return new StoryId(value);
    }


    @Override
    public String asString() {
        return value;

    }
}
