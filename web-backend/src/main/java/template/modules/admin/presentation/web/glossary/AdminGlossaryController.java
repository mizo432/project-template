package template.modules.admin.presentation.web.glossary;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
