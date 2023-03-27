package com.undecided.projectTemplate.resource.infra.dao.projects;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.jdbc.Result;

import java.util.List;

//@Dao
//@ConfigAutowireable
public interface ProjectsDao {

    @Select
    Project findOneById(SnowflakeIdentifier<Project> id);

    @Select
    List<Project> selectAll();

    @Insert
    Result<Project> insert(Project project);

    @Update
    Result<Project> update(Project project);

    @Delete(sqlFile = true)
    int delete(SnowflakeIdentifier<Project> id);

}
