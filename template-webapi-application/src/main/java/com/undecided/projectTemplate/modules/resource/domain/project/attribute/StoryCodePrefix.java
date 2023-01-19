package com.undecided.projectTemplate.modules.resource.domain.project.attribute;

import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import com.undecided.projectTemplate.shared.value.StringValue;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.primitive.string.Strings2;

@Getter
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
public class StoryCodePrefix implements StringValue<StoryCodePrefix>, Serializable {

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
        StringPreconditions.checkNotEmpty(value, "ストーリーコードの接頭子");
        return new StoryCodePrefix(value);

    }

    public static StoryCodePrefix reconstruct(String value) {
        return new StoryCodePrefix(value);

    }
}
