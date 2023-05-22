package com.undecided.projectTemplate.modules.relationshipMgmt.party.domain.organization;

import com.undecided.projectTemplate.modules.relationshipMgmt.party.domain.party.AbstractParty;
import com.undecided.projectTemplate.modules.relationshipMgmt.party.domain.party.Party;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;

public class AbstractOrganization extends AbstractParty {
    public AbstractOrganization(SnowflakeId<Party> id) {
        super(id);
    }
}
