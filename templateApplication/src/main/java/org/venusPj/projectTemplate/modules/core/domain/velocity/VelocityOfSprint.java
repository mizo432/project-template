package org.venusPj.projectTemplate.modules.core.domain.velocity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.venusPj.projectTemplate.modules.resource.domain.project.ProjectId;
import org.venusPj.projectTemplate.modules.resource.domain.sprint.SprintId;
import org.venusPj.projectTemplate.modules.resource.domain.sprint.SprintNumber;
import org.venusPj.projectTemplate.shared.value.BigDecimalValue;

/**
 * スプリントあたりの速度
 */
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VelocityOfSprint implements BigDecimalValue<VelocityOfSprint> {

    private final ProjectId projectId;

    private final SprintId sprintId;

    private final SprintNumber sprintNumber;

    private final EffortOfSprint effort;
    private final DaysOfSprint days;

    public static VelocityOfSprint create(ProjectId projectId, SprintId sprintId,
        SprintNumber sprintNumber, EffortOfSprint effort, DaysOfSprint days) {
        return new VelocityOfSprint(projectId, sprintId, sprintNumber, effort, days);

    }

    @Override
    public BigDecimal getValue() {
        if (effort.isZero()) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(effort.getValue()).divide(BigDecimal.valueOf(days.getValue()), 2,
            RoundingMode.HALF_UP);
    }
}
