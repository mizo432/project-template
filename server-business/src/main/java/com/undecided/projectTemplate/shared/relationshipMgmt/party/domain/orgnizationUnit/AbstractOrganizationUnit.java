package com.undecided.projectTemplate.shared.relationshipMgmt.party.domain.orgnizationUnit;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import lombok.Getter;

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
