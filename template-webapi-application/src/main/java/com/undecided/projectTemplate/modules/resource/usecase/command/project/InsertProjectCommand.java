package com.undecided.projectTemplate.modules.resource.usecase.command.project;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.undecided.projectTemplate.modules.resource.domain.project.Project;
import com.undecided.projectTemplate.modules.resource.domain.project.ProjectRepository;

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
