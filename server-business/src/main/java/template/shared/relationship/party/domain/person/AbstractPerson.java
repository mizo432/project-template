package template.shared.relationship.party.domain.person;

import template.shared.entity.id.SnowflakeId;
import template.shared.relationship.party.domain.party.Party;

public class AbstractPerson extends Party {
    public AbstractPerson(SnowflakeId id) {
        super(id);
    }
}
