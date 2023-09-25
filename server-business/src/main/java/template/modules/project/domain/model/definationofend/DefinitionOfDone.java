package template.modules.project.domain.model.definationofend;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import template.modules.project.domain.model.definationofend.attribute.DefinitionOfEndAttribute;
import template.shared.entity.id.SnowflakeId;

/**
 * 各ストーリーの完了の定義
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "create")
public class DefinitionOfDone {
    private final SnowflakeId projectId;
    private final DefinitionOfEndAttribute attribute;

}
