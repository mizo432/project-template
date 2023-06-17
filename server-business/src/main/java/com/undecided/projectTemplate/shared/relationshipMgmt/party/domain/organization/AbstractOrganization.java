package com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.organization;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.party.AbstractParty;

/**
 * 組織基底クラス.
 */
public class AbstractOrganization extends AbstractParty {
    /**
     * コンストラクター.
     *
     * @param id ID
     */
    protected AbstractOrganization(SnowflakeId id) {
        super(id);
    }
}
