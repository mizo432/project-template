package template.shared.relationship.party.domain.party;

import template.shared.entity.annotation.Arche;
import template.shared.entity.annotation.ArcheType;
import template.shared.entity.id.SnowflakeId;

@Arche(ArcheType.PARTY_PLACE_OR_THING)
public abstract class Party extends AbstractParty {
    public Party(SnowflakeId id) {
        super(id);
    }

}
