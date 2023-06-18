package template.shared.relationshipMgmt.party.domain.person;

import template.shared.entity.id.SnowflakeId;
import template.shared.relationshipMgmt.party.domain.party.Party;

public class AbstractPerson extends Party {
    public AbstractPerson(SnowflakeId id) {
        super(id);
    }
}
