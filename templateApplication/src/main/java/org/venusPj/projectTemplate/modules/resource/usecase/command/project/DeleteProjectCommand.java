package org.venusPj.projectTemplate.modules.resource.usecase.command.project;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.modules.resource.domain.project.ProjectRepository;
import org.venusPj.projectTemplate.shared.entity.id.Identifier;

@Service
public class DeleteProjectCommand {

    private final ProjectRepository projectRepository;

    public DeleteProjectCommand(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public void delete(Identifier<Project> projectId) {
        projectRepository.delete(projectId);
        
    }
}
