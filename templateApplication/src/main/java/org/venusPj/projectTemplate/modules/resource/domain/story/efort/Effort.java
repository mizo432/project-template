package org.venusPj.projectTemplate.modules.resource.domain.story.efort;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.primitive.object.Objects2;
import org.venusPj.projectTemplate.shared.value.IntegerValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Effort implements IntegerValue<Effort> {

    private final static Effort EMPTY = new Effort(null);

    private final Integer value;

    @Override
    public Integer getValue() {
        return value;

    }

    public static Effort of(Integer value) {
        return new Effort(value);
    }

    public static Effort reconstruct(Integer value) {
        if (Objects2.isNull(value)) {
            return EMPTY;
        }
        return new Effort(value);
    }
}
