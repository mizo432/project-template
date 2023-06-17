package com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.organization;

import com.undecided.projectTemplate.shared.entity.annotation.Arche;
import com.undecided.projectTemplate.shared.entity.annotation.ArcheType;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;

@Arche(ArcheType.PARTY_PLACE_OR_THING)
public class Organization extends AbstractOrganization {
    public Organization(SnowflakeId id) {
        super(id);
    }
}