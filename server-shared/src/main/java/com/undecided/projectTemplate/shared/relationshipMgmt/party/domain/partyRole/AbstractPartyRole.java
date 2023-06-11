package com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.partyRole;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
public class AbstractPartyRole {
    private final SnowflakeId assignedNumber;

    private final PartyRoleStatus status;

    private final SnowflakeId partyId;

}
