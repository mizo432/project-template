package template.modules.project.appl.command.project;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import template.modules.admin.domain.model.project.Project;
import template.modules.admin.domain.model.project.ProjectRepository;

@Service
public class InsertProjectCommand {

    private final ProjectRepository projectRepository;

    public InsertProjectCommand(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public void insert(Project project) {
        projectRepository.insert(project);
    }
}
