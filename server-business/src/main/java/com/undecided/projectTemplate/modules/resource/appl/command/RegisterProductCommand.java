package com.undecided.projectTemplate.modules.resource.appl.command;

import com.undecided.projectTemplate.modules.project.domain.model.project.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterProductCommand {

    public Project register(Project project) {
        return Project.create(project);
    }
}
