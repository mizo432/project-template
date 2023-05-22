package com.undecided.projectTemplate.relationshipMgmt.party.domain.organizationRole;

import com.undecided.projectTemplate.relationshipMgmt.party.domain.partyRole.PartyRole;
import com.undecided.projectTemplate.shared.entity.annotation.Arche;
import com.undecided.projectTemplate.shared.entity.annotation.ArcheType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "create")
@Arche(ArcheType.ROLE)
public class AbstractOrganizationRole extends PartyRole {
}
