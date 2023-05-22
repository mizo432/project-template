package com.undecided.projectTemplate.relationshipMgmt.party.domain.person;

import com.undecided.projectTemplate.relationshipMgmt.party.domain.party.Party;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;

public class AbstractPerson extends Party {
    public AbstractPerson(SnowflakeId<Party> id) {
        super(id);
    }
}
