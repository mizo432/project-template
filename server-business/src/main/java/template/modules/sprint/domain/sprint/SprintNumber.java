package template.modules.sprint.domain.sprint;

import com.google.common.base.Function;
import com.undecided.primitive.object.Objects2;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import template.shared.value.AbstractIntegerValue;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class SprintNumber extends AbstractIntegerValue {

    SprintNumber(Integer value) {
        super(value);
    }

    public static SprintNumber reconstruct(Integer value) {
        return new SprintNumber(value);

    }

    @Override
    public String asString() {
        return Objects2.ifPresent(getValue(),
                (Function<Integer, String>) Object::toString);

    }

}
