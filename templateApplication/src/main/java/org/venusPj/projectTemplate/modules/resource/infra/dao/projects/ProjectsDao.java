package org.venusPj.projectTemplate.modules.resource.infra.dao.projects;

import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Dao
@ConfigAutowireable
public interface ProjectsDao {

    @Select
    Project findOneById(Identifier<Project> projectId);

    @Select
    List<Project> selectAll();

    @Insert
    int insert(Project project);

    @Update
    int update(Project project);

    @Delete(sqlFile = true)
    int delete(Identifier<Project> projectId);

}
