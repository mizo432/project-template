package com.undecided.projectTemplate.modules.resource.presentation.web.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import template.modules.project.appl.command.project.DeleteProjectCommand;
import template.modules.project.appl.command.project.InsertProjectCommand;
import template.modules.project.appl.command.project.UpdateProjectCommand;
import template.modules.project.appl.query.project.ProjectFetcher;
import template.modules.project.domain.model.project.Project;
import template.shared.entity.id.SnowflakeId;

@Controller
@RequestMapping(path = "/project")
public class ProjectController {

    private final ProjectFetcher projectFetcher;
    private final InsertProjectCommand insertProjectCommand;
    private final UpdateProjectCommand updateProjectCommand;
    private final DeleteProjectCommand deleteProjectCommand;

    public ProjectController(ProjectFetcher projectFetcher,
                             InsertProjectCommand insertProjectCommand, UpdateProjectCommand updateProjectCommand,
                             DeleteProjectCommand deleteProjectCommand) {
        this.projectFetcher = projectFetcher;

        this.insertProjectCommand = insertProjectCommand;
        this.updateProjectCommand = updateProjectCommand;
        this.deleteProjectCommand = deleteProjectCommand;
    }

    // display list of employees
    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("list", projectFetcher.selectAll());
        return "/project/index";
    }

    @GetMapping("/showNewProjectForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Project project = Project.newInstance();
        model.addAttribute("project", project);
        return "/project/new_project";
    }

    @PostMapping("/insertProject")
    public String postProject(@ModelAttribute("project") Project project) {
        insertProjectCommand.insert(project);

        return "redirect:/project";
    }

    @GetMapping("/delete/{projectId}")
    public String deleteEmployee(
            @PathVariable(value = "projectId") SnowflakeId id) {
        deleteProjectCommand.delete(id);
        return "redirect:/project";

    }

    @GetMapping("/showFormForUpdate/{projectId}")
    public String showFormForUpdate(
            @PathVariable(value = "projectId") SnowflakeId id, Model model) {

        Project project = projectFetcher.findOneBy(id);

        model.addAttribute("project", project);

        return "project/update_project_form";
    }

    @PostMapping("/update")
    public String putProject(@ModelAttribute("project") Project project) {
        updateProjectCommand.update(project);

        return "redirect:/project";
    }

}
