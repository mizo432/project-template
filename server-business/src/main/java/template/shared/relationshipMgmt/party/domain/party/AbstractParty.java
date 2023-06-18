package template.shared.relationshipMgmt.party.domain.party;

import lombok.AllArgsConstructor;
import template.shared.entity.id.SnowflakeId;

/**
 * パーティ基底クラス.
 */
@AllArgsConstructor
public class AbstractParty {
    private final SnowflakeId id;

}
