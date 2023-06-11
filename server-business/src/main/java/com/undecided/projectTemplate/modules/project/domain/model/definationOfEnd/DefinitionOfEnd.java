package com.undecided.projectTemplate.modules.project.domain.model.definationOfEnd;

import com.undecided.projectTemplate.modules.project.domain.model.definationOfEnd.attribute.DefinitionOfEndAttribute;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * 各ストーリーの完了の定義
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "create")
public class DefinitionOfEnd {
    private final SnowflakeId projectId;
    private final DefinitionOfEndAttribute attribute;

}
