package com.undecided.projectTemplate.modules.relationshipMgmt.party.domain.person;

import com.undecided.projectTemplate.modules.relationshipMgmt.party.domain.party.Party;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;

public class Person extends AbstractPerson {
    public Person(SnowflakeId<Party> id) {
        super(id);
    }
}
