package com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.party;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.AllArgsConstructor;

/**
 * パーティ基底クラス.
 */
@AllArgsConstructor
public class AbstractParty {
    private final SnowflakeId id;

}
