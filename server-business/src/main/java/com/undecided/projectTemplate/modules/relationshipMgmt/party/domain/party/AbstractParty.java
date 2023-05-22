package com.undecided.projectTemplate.modules.relationshipMgmt.party.domain.party;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AbstractParty {
    private final SnowflakeId<Party> id;
}
