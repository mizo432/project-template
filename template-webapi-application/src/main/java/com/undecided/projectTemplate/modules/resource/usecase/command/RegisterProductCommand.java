package com.undecided.projectTemplate.modules.resource.usecase.command;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.undecided.projectTemplate.modules.resource.domain.project.Project;

@Service
@Transactional
public class RegisterProductCommand {

    public Project register(Project project) {
        return Project.create(project);
    }
}
