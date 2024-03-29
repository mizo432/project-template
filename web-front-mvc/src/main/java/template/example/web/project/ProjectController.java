package template.example.web.project;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import template.modules.admin.domain.model.project.Project;
import template.modules.admin.domain.model.project.attribute.ProjectCode;
import template.modules.example.appl.command.employee.EntityNotFoundException;
import template.modules.project.appl.command.project.InsertProjectCommand;
import template.modules.project.appl.query.project.ProjectFetcher;

@Controller
@RequestMapping("/projects")
@Slf4j
public class ProjectController {
    private final InsertProjectCommand insertProjectCommand;
    private final ProjectFetcher projectFetcher;

    public ProjectController(
            InsertProjectCommand insertProjectCommand,
            ProjectFetcher projectFetcher) {
        this.insertProjectCommand = insertProjectCommand;
        this.projectFetcher = projectFetcher;
    }


    @GetMapping("/entry")
    public ModelAndView entry(ModelAndView mov) {
        mov.addObject("entry", new EntryForm());
        mov.setViewName("/project/entry");
        return mov;

    }

    @PostMapping("/insert")
    public ModelAndView insert(@ModelAttribute EntryForm entryForm, ModelAndView mov) {
        Project project = Project.create(entryForm.getProject().getAttribute());
        log.debug("project" + project);
        insertProjectCommand.insert(project);
        mov.setViewName("redirect:/");
        return mov;

    }

    @GetMapping("/{projectCode}")
    public ModelAndView get(@PathParam("projectCode") ProjectCode projectCode, @ModelAttribute EntryForm entryForm, ModelAndView mov) {
        Project project;
        try {
            project = projectFetcher.findOneByCode(projectCode);

        } catch (EntityNotFoundException e) {
            mov.setStatus(HttpStatusCode.valueOf(404));
            return mov;
        }
        mov.setViewName("project/sprintList");
        return mov;

    }

}
