package com.undecided.projectTemplate.business.domain.entity;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import java.util.List;
import java.util.Optional;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

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
    Optional<ModelEntity> findOneById(SnowflakeIdentifier<ModelEntity> id);

    /**
     * プロジェクトIDを元にモデルエンティティを返却します。
     *
     * @param projectId プロジェクトID
     * @return モデルエンティティ(複数)
     */
    @Select
    List<ModelEntity> selectByProjectId(SnowflakeIdentifier<Project> projectId);

}
