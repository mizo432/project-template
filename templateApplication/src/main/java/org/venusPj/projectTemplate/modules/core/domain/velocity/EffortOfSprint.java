package org.venusPj.projectTemplate.modules.core.domain.velocity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.value.IntegerValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class EffortOfSprint implements IntegerValue<EffortOfSprint> {

    private final Integer value;

    @Override
    public Integer getValue() {
        return value;

    }

    public static EffortOfSprint of(Integer value) {
        return new EffortOfSprint(value);
    }

    public static EffortOfSprint reconstruct(Integer value) {
        return new EffortOfSprint(value);
    }

    public boolean isZero() {
        return value == null || value.equals(0);
    }
}
