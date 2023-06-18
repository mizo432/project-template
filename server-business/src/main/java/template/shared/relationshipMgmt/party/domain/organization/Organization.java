package template.shared.relationshipMgmt.party.domain.organization;

import template.shared.entity.annotation.Arche;
import template.shared.entity.annotation.ArcheType;
import template.shared.entity.id.SnowflakeId;

@Arche(ArcheType.PARTY_PLACE_OR_THING)
public class Organization extends AbstractOrganization {
    public Organization(SnowflakeId id) {
        super(id);
    }
}
