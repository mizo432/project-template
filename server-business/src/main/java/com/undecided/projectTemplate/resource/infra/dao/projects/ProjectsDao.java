package com.undecided.projectTemplate.resource.infra.dao.projects;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.shared.entity.id.UlidIdentifier;
import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@Dao
@ConfigAutowireable
public interface ProjectsDao {

    @Select
    Project findOneById(UlidIdentifier<Project> projectId);

    @Select
    List<Project> selectAll();

    @Insert
    Result<Project> insert(Project project);

    @Update
    Result<Project> update(Project project);

    @Delete(sqlFile = true)
    int delete(UlidIdentifier<Project> projectId);

}