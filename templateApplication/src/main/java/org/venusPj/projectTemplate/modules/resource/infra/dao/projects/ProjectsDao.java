package org.venusPj.projectTemplate.modules.resource.infra.dao.projects;

import java.util.Optional;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Dao
public interface ProjectsDao {

    @Select()
    Optional<Project> findOneById(Identifier<Project> projectId, SelectOptions options);

    @Insert
    int insert(Project project);

    @Insert
    int update(Project project);

    @Delete
    int delete(Project project);

}
