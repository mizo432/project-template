package com.undecided.projectTemplate.project.domain.appl.command.project;

import com.undecided.projectTemplate.project.domain.model.project.Project;
import org.springframework.stereotype.Service;

@Service
public class RegisterProjectCommand {
    public Project register(Project project) {
        return project;
    }
}
