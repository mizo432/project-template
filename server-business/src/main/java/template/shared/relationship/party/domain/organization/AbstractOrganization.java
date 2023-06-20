package template.shared.relationship.party.domain.organization;

import template.shared.entity.id.SnowflakeId;
import template.shared.relationship.party.domain.party.AbstractParty;

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
