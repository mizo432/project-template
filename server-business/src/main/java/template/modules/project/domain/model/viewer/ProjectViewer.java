package template.modules.project.domain.model.viewer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import template.shared.entity.id.SnowflakeId;

@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "create")
@EqualsAndHashCode
public class ProjectViewer {
    SnowflakeId productId;
    SnowflakeId personId;

}
