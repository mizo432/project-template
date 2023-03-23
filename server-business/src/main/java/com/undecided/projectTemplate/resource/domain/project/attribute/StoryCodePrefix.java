package com.undecided.projectTemplate.resource.domain.project.attribute;

import com.undecided.primitive.string.Strings2;
import com.undecided.projectTemplate.shared.precondition.string.StringPreconditions;
import com.undecided.projectTemplate.shared.value.AbstractStringValue;
import lombok.Getter;

@Getter
public class StoryCodePrefix extends AbstractStringValue {

    private static final StoryCodePrefix EMPTY = new StoryCodePrefix(Strings2.EMPTY);

    StoryCodePrefix(String value) {
        super(value);
    }

    public static StoryCodePrefix empty() {
        return EMPTY;
    }


    public static StoryCodePrefix of(String value) {
        StringPreconditions.checkNotEmpty(value, "ストーリーコードの接頭子");
        return new StoryCodePrefix(value);

    }

    public static StoryCodePrefix reconstruct(String value) {
        return new StoryCodePrefix(value);

    }
}
