package com.undecided.projectTemplate.resource.buisiness.command.project;

import com.undecided.projectTemplate.resource.domain.project.Project;
import com.undecided.projectTemplate.resource.domain.project.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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