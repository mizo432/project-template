package com.undecided.projectTemplate.modules.product.domain.model.business.entity;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import java.util.Optional;

/**
 * モデルエンティティ用リポジトリー
 */
@Dao
@ConfigAutowireable
public interface ModelEntityRepository {


    /**
     * モデルエンティティIDを元にモデルエンティティを返却します。
     *
     * @param id モデルエンティティID
     * @return モデルエンティティ
     */
    @Select
    Optional<ModelEntity> findOneById(SnowflakeId id);

    /**
     * プロジェクトIDを元にモデルエンティティを返却します。
     *
     * @param projectId プロジェクトID
     * @return モデルエンティティ(複数)
     */
    @Select
    List<ModelEntity> selectByProjectId(SnowflakeId projectId);

}