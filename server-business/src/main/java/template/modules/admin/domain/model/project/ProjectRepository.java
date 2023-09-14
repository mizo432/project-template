package template.modules.admin.domain.model.project;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import template.modules.admin.domain.model.project.attribute.ProjectCode;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

/**
 * プロジェクトリポジトリー.
 */
@ConfigAutowireable
@Dao
public interface ProjectRepository {

    @Select
    Project findOneById(SnowflakeId projectId);

    @Select
    List<Project> selectAll();

    @Insert
    Result<Project> insert(Project project);

    @Update
    Result<Project> update(Project project);

    @Select
    Project findOneByProjectCode(ProjectCode projectCode);

    @Delete(sqlFile = true)
    int deleteById(SnowflakeId projectId);
}
