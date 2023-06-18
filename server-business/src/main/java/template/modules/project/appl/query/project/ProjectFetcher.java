package template.modules.project.appl.query.project;

import org.springframework.stereotype.Service;
import template.modules.project.domain.model.project.Project;
import template.modules.project.domain.model.project.ProjectRepository;
import template.modules.project.domain.model.project.attribute.ProjectCode;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

@Service
public class ProjectFetcher {

    private final ProjectRepository projectRepository;


    public ProjectFetcher(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> selectAll() {
        return projectRepository.selectAll();

    }

    public Project findOneBy(SnowflakeId projectId) {
        return projectRepository.findOneById(projectId);

    }

    public Project findOneByCode(ProjectCode projectCode) {
        return projectRepository.findOneByCode(projectCode);

    }
}
