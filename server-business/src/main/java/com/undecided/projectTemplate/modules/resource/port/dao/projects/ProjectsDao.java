package com.undecided.projectTemplate.modules.resource.port.dao.projects;

import com.undecided.projectTemplate.modules.project.domain.model.project.Project;
import com.undecided.projectTemplate.modules.project.domain.model.project.attribute.ProjectCode;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.List;

@Dao
@ConfigAutowireable
public interface ProjectsDao {

    @Select
    Project findOneById(SnowflakeId<Project> id);

    @Select
    List<Project> selectAll();

    @Insert(sqlFile = true)
    Result<Project> insert(Project project);

    @Update
    Result<Project> update(Project project);

    @Delete(sqlFile = true)
    int delete(SnowflakeId<Project> id);

    @Select
    Project findOneByCode(ProjectCode projectCode);

}
