package org.venusPj.projectTemplate.modules.resource.domain.project.attribute;

import static org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions.checkNotEmpty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.primitive.string.Strings2;
import org.venusPj.projectTemplate.shared.value.StringValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
public class StoryCodePrefix implements StringValue<StoryCodePrefix> {

    private static final StoryCodePrefix EMPTY = new StoryCodePrefix(Strings2.EMPTY);
    private final String value;

    public static StoryCodePrefix empty() {
        return EMPTY;
    }

    @Override
    public String asString() {
        return value;
    }

    public static StoryCodePrefix of(String value) {
        checkNotEmpty(value, "ストーリーコードの接頭子");
        return new StoryCodePrefix(value);

    }

    public static StoryCodePrefix reconstruct(String value) {
        return new StoryCodePrefix(value);

    }
}
