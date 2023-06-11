package com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.orgnizationUnit;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.Getter;

@Getter
public class AbstractOrganizationUnit {
    private final SnowflakeId id;

    public AbstractOrganizationUnit(SnowflakeId id) {
        this.id = id;
    }


}
