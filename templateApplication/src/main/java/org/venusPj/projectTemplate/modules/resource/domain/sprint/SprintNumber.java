package org.venusPj.projectTemplate.modules.resource.domain.sprint;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.shared.value.IntegerValue;

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