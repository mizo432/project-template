package template.modules.project.port.dataSource.project;

import org.springframework.stereotype.Component;
import template.modules.project.domain.model.project.Project;
import template.modules.project.domain.model.project.ProjectRepository;
import template.modules.project.domain.model.project.attribute.ProjectCode;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

@Component
public class ProjectDataSource implements ProjectRepository {
    @Override
    public Project findOneById(SnowflakeId id) {
        return null;
    }

    @Override
    public List<Project> selectAll() {
        return null;
    }

    @Override
    public Project insert(Project project) {
        return null;
    }

    @Override
    public Project update(Project project) {
        return null;
    }

    @Override
    public void delete(SnowflakeId id) {

    }

    @Override
    public Project findOneByCode(ProjectCode projectCode) {
        return null;
    }
}
