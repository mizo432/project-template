package template.modules.project.appl.command.project;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.project.ProjectRepository;
import template.shared.entity.id.SnowflakeId;

@Service
public class DeleteProjectCommand {

    private final ProjectRepository projectRepository;

    public DeleteProjectCommand(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public void delete(SnowflakeId projectId) {
        projectRepository.deleteById(projectId);

    }
}
