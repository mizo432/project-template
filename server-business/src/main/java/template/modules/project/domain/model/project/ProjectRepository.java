package template.modules.project.domain.model.project;

import template.modules.project.domain.model.project.attribute.ProjectCode;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

public interface ProjectRepository {

    Project findOneById(SnowflakeId id);

    List<Project> selectAll();

    Project insert(Project project);

    Project update(Project project);

    void delete(SnowflakeId id);

    Project findOneByCode(ProjectCode projectCode);

}
