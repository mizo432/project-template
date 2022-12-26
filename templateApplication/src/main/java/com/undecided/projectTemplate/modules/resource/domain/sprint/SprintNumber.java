package com.undecided.projectTemplate.modules.resource.domain.sprint;

import com.undecided.projectTemplate.shared.value.IntegerValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class SprintNumber implements IntegerValue<SprintNumber> {

    private final Integer value;

    public static SprintNumber reconstruct(Integer value) {
        return new SprintNumber(value);

    }

    @Override
    public Integer getValue() {
        return value;
    }
}
