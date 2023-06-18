package template.modules.story.domain.model.attribute;

import lombok.Getter;
import org.seasar.doma.Domain;
import template.shared.value.AbstractStringValue;
import template.shared.value.CodeValue;

@Getter
@Domain(valueType = String.class, factoryMethod = "reconstruct")
public class StoryCode extends AbstractStringValue implements CodeValue {


    StoryCode(String value) {
        super(value);
    }

    public static StoryCode reconstruct(String value) {
        return new StoryCode(value);

    }

}
