package com.undecided.projectTemplate.example.web.project;

import com.undecided.projectTemplate.resource.domain.project.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectAndStaticsQuery {
    public Project.Projects selectAll() {
        return Project.Projects.empty();
    }
}
