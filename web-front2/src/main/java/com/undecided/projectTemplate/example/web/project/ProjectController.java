package com.undecided.projectTemplate.example.web.project;

import com.undecided.projectTemplate.resource.domain.project.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    private final ProjectAndStaticsQuery projectAndStaticsQuery;

    public ProjectController(ProjectAndStaticsQuery projectAndStaticsQuery) {
        this.projectAndStaticsQuery = projectAndStaticsQuery;
    }

    @GetMapping(path = "projects")
    public String list() {

        Project.Projects projects = projectAndStaticsQuery.selectAll();

        return "project/projectList";


    }

}
