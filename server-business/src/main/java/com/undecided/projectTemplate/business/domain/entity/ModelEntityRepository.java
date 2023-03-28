package com.undecided.projectTemplate.business.domain.entity;

import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface ModelEntityRepository {

    @Select
    ModelEntity findOneById(SnowflakeIdentifier<ModelEntity> id);

}
