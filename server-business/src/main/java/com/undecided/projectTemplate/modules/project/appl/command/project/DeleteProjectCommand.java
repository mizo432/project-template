package com.undecided.projectTemplate.modules.project.appl.command.project;

import com.undecided.projectTemplate.modules.project.domain.model.project.ProjectRepository;
import com.undecided.projectTemplate.shared.entity.id.SnowflakeId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteProjectCommand {

    private final ProjectRepository projectRepository;

    public DeleteProjectCommand(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public void delete(SnowflakeId projectId) {
        projectRepository.delete(projectId);

    }
}
