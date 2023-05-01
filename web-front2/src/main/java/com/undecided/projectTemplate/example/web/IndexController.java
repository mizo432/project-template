package com.undecided.projectTemplate.example.web;

import com.undecided.projectTemplate.resource.buisiness.query.project.ProjectFetcher;
import com.undecided.projectTemplate.resource.domain.project.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    private final ProjectFetcher projectFetcher;

    public IndexController(ProjectFetcher projectFetcher) {
        this.projectFetcher = projectFetcher;
    }

    @GetMapping
    public ModelAndView get(ModelAndView mov) {

        Project.Projects projects = Project.Projects.reconstruct(projectFetcher.selectAll());
        if (projects.isEmpty()) {
            mov.setViewName("redirect:projects/entry");

        } else {
            mov.addObject("title", "プロジェクト一覧");
            mov.addObject("projects", projects);
            mov.setViewName("index/index");

        }
        return mov;

    }

}
