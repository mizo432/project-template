package template.shared.relationshipMgmt.party.domain.orgnizationUnit;

import lombok.Getter;
import template.shared.entity.id.SnowflakeId;

/**
 * 組織ユニットの基底クラス.
 */
@Getter
public class AbstractOrganizationUnit {
    private final SnowflakeId id;

    /**
     * コンストラクター
     *
     * @param id ID
     */
    protected AbstractOrganizationUnit(SnowflakeId id) {
        this.id = id;
    }


}
