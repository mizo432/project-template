package com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.person;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.party.Party;

public class AbstractPerson extends Party {
    public AbstractPerson(SnowflakeId id) {
        super(id);
    }
}
