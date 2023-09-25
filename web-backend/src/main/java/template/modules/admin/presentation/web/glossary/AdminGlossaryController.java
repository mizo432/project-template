package template.modules.admin.presentation.web.glossary;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import template.modules.admin.appl.command.glossaryitem.InsertGlossaryItemCommand;
import template.modules.admin.appl.query.glossary.GlossaryItemQuery;

import java.util.List;

/**
 * 祝日コントローラー
 */
@Controller
@AllArgsConstructor
@RequestMapping(path = {"/admin/glossary",})
public class AdminGlossaryController {

    private final GlossaryItemQuery glossaryItemQuery;
    private final InsertGlossaryItemCommand insertGlossaryItemCommand;

    /**
     * /admin/glossary GET時のエンドポイント.
     *
     * @param model モデル
     * @return テンプレート
     */
    @GetMapping
    public String get(Model model) {
        List<GlossaryItemForm> formList = GlossaryItemForm.GlossaryItemFormList.reconstruct(glossaryItemQuery.selectAll());
        model.addAttribute("formList", formList);
        return "admin/glossary/list";

    }

    /**
     * /admin/glossary/insertForm 新規入力フォームGET時のエンドポイント.
     *
     * @param model モデル
     * @return テンプレート
     */
    @GetMapping(path = "/insertForm")
    public String insertForm(Model model) {
        GlossaryItemForm glossaryItemForm = new GlossaryItemForm();
        model.addAttribute("form", glossaryItemForm);
        return "admin/glossary/insertForm";

    }

    /**
     * /admin/glossary/insert POST時のエンドポイント.
     *
     * @param glossaryForm 入力フォーム
     * @return テンプレート
     */
    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute(name = "form") GlossaryItemForm glossaryForm) {
        insertGlossaryItemCommand.execute(glossaryForm.convertToInsertModel());
        return "redirect:/admin/glossary";

    }

}
