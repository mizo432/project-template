package org.venusPj.projectTemplate.modules.resource.domain.product;

import static org.venusPj.projectTemplate.shared.precondition.string.StringPreconditions.checkNotEmpty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.value.StringValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
public class StoryCodePrefix implements StringValue<StoryCodePrefix> {

    private final String value;

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
