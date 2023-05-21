package com.undecided.projectTemplate.resource.port.dao.projects;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.resource.domain.project.attribute.ProjectCode;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import java.util.List;

@Dao
@ConfigAutowireable
public interface ProjectsDao {

    @Select
    Project findOneById(SnowflakeIdentifier<Project> id);

    @Select
    List<Project> selectAll();

    @Insert(sqlFile = true)
    Result<Project> insert(Project project);

    @Update
    Result<Project> update(Project project);

    @Delete(sqlFile = true)
    int delete(SnowflakeIdentifier<Project> id);

    @Select
    Project findOneByCode(ProjectCode projectCode);

}
