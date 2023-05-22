package com.undecided.projectTemplate.relationshipMgmt.party.domain.party;

import com.undecided.projectTemplate.shared.entity.annotation.Arche;
import com.undecided.projectTemplate.shared.entity.annotation.ArcheType;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;

@Arche(ArcheType.PARTY_PLACE_OR_THING)
public abstract class Party extends AbstractParty {
    public Party(SnowflakeId<Party> id) {
        super(id);
    }

}
