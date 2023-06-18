package template.shared.relationshipMgmt.party.domain.partyRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import template.shared.entity.id.SnowflakeId;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
public class AbstractPartyRole {
    private final SnowflakeId assignedNumber;

    private final PartyRoleStatus status;

    private final SnowflakeId partyId;

}
