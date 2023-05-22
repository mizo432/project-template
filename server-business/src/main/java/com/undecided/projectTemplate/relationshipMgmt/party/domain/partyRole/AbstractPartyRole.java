package com.undecided.projectTemplate.relationshipMgmt.party.domain.partyRole;

import com.undecided.projectTemplate.relationshipMgmt.party.domain.party.Party;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
public class AbstractPartyRole {
    private final SnowflakeId<PartyRole> assignedNumber;

    private final PartyRoleStatus status;

    private final SnowflakeId<Party> partyId;

}
