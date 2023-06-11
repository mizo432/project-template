package com.undecided.projectTemplate.project.domain.model.viewer;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "create")
@EqualsAndHashCode
public class ProjectViewer {
    SnowflakeId productId;
    SnowflakeId personId;

}
