package com.undecided.projectTemplate.relationshipMgmt.party.domain.orgnizationUnit;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.Getter;

@Getter
public class AbstractOrganizationUnit {
    private final SnowflakeId<OrganizationUnit> id;

    public AbstractOrganizationUnit(SnowflakeId<OrganizationUnit> id) {
        this.id = id;
    }


}
