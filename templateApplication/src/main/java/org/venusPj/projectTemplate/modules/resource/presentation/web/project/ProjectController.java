package org.venusPj.projectTemplate.modules.resource.presentation.web.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.venusPj.projectTemplate.modules.resource.domain.project.Project;
import org.venusPj.projectTemplate.modules.resource.usecase.command.project.InsertProjectCommand;
import org.venusPj.projectTemplate.modules.resource.usecase.query.ProjectFetcher;

@Controller
@RequestMapping(path = "/project")
public class ProjectController {

    private final ProjectFetcher projectFetcher;
    private final InsertProjectCommand insertProjectCommand;

    public ProjectController(ProjectFetcher projectFetcher,
        InsertProjectCommand insertProjectCommand) {
        this.projectFetcher = projectFetcher;

        this.insertProjectCommand = insertProjectCommand;
    }

    // display list of employees
    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("list", projectFetcher.selectAll());
        return "/project/index";
    }

    @GetMapping("/showNewProjectForm")
//    @TransactionTokenCheck(type = TransactionTokenType.BEGIN)
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Project project = Project.newInstance();
        model.addAttribute("project", project);
        return "/project/new_project";
    }

    @PostMapping("/insertProject")
//    @TransactionTokenCheck(type = TransactionTokenType.IN)
    public String postProject(@ModelAttribute("project") Project project) {
        // save employee to database
        insertProjectCommand.insert(project);

        return "redirect:/project";
    }
}
