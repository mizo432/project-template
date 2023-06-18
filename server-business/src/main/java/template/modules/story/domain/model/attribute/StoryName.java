package template.modules.story.domain.model.attribute;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class StoryName extends AbstractStringValue {


    public StoryName(String value) {
        super(value);
    }

    public static StoryName reconstruct(String value) {
        return new StoryName((value));
    }

}
