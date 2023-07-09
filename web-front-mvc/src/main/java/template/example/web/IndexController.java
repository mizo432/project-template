package template.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import template.modules.project.appl.query.project.ProjectFetcher;
import template.modules.project.domain.model.project.Project;

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
