package com.undecided.projectTemplate.modules.project.domain.appl.command.project;

import com.undecided.projectTemplate.modules.project.domain.model.project.Project;
import org.springframework.stereotype.Service;

@Service
public class RegisterProjectCommand {
    public Project register(Project project) {
        return project;
    }
}
