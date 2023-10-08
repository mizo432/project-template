package template.modules.admin.presentation.web.project;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import template.modules.admin.appl.command.project.InsertProjectCommand;
import template.modules.admin.appl.query.project.ProjectQuery;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = {"/admin/project",})
public class AdminProjectController {

    private final InsertProjectCommand insertProjectCommand;
    private final ProjectQuery projectQuery;

    /**
     * /admin/holiday/insertForm 新規入力フォームGET時のエンドポイント.
     *
     * @param model モデル
     * @return テンプレート
     */
    @GetMapping(path = "/insertForm")
    public String insertForm(Model model) {
        ProjectForm projectForm = new ProjectForm();
        model.addAttribute("form", projectForm);
        return "admin/project/insertForm";

    }

    /**
     * /admin/project/insert POST時のエンドポイント.
     *
     * @param projectForm 入力フォーム
     * @return テンプレート
     */
    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute(name = "form") ProjectForm projectForm) {
        insertProjectCommand.execute(projectForm.convertToInsertModel());
        return "redirect:/admin/project/achievableList";

    }

    @GetMapping(path = "/achievableList")
    String achievableList(Model model) {

        List<ProjectForm> formList = ProjectForm.convertFromProjectListToList(projectQuery.selectAchievable());
        model.addAttribute("formList", formList);
        return "/admin/project/achievableList";
    }

}
