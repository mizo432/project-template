package org.venusPj.projectTemplate.modules.resource.usecase.command.project;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.modules.resource.domain.project.ProjectRepository;

@Service
public class UpdateProjectCommand {

    private final ProjectRepository projectRepository;

    public UpdateProjectCommand(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public void update(Project project) {
        projectRepository.update(project);
    }
}
