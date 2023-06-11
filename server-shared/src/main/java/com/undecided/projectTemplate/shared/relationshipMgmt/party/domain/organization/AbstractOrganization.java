package com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.organization;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.party.AbstractParty;

public class AbstractOrganization extends AbstractParty {
    public AbstractOrganization(SnowflakeId id) {
        super(id);
    }
}
