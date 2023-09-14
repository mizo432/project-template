package template.modules.project.domain.appl.command.project;

import org.springframework.stereotype.Service;
import template.modules.admin.domain.model.project.Project;

@Service
public class RegisterProjectCommand {
    public Project register(Project project) {
        return project;
    }
}
