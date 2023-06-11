package com.undecided.projectTemplate.project.appl.command.project;

import com.undecided.projectTemplate.project.domain.model.project.Project;
import com.undecided.projectTemplate.project.domain.model.project.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
