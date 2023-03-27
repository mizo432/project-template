package com.undecided.projectTemplate.resource.buisiness.command.project;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.resource.domain.project.ProjectRepository;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeIdentifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteProjectCommand {

    private final ProjectRepository projectRepository;

    public DeleteProjectCommand(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public void delete(SnowflakeIdentifier<Project> projectId) {
        projectRepository.delete(projectId);

    }
}
