package com.undecided.projectTemplate.modules.core.domain.velocity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import com.undecided.projectTemplate.shared.value.IntegerValue;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class DaysOfSprint implements IntegerValue<DaysOfSprint> {

    private final Integer value;

    @Override
    public Integer getValue() {
        return value;

    }

    public static DaysOfSprint of(Integer value) {
        return new DaysOfSprint(value);
    }

    public static DaysOfSprint reconstruct(Integer value) {
        return new DaysOfSprint(value);
    }

}
