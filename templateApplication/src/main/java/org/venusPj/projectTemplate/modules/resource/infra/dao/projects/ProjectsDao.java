package org.venusPj.projectTemplate.modules.resource.infra.dao.projects;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Dao
@ConfigAutowireable
public interface ProjectsDao {

    @Select
    @Cacheable(value = "projectCache", key = "'projects/' + #projectId")
    Project findOneById(Identifier<Project> projectId);

    @Insert
    @CachePut(value = "projectCache", key = "'projects/' + #project.projectId")
    int insert(Project project);

    @Update
    @CachePut(value = "projectCache", key = "'projects/' + #project.projectId")
    int update(Project project);

    @Delete
    @CacheEvict(value = "projectCache", key = "'projects/' + #project.projectId")
    int delete(Project project);

}
