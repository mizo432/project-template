package template.modules.admin.presentation.web.glossary;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import template.modules.admin.appl.command.glossary.item.CreateItemCommand;
import template.modules.admin.appl.command.glossary.item.DropItemCommand;
import template.modules.admin.appl.command.glossary.item.UpdateItemCommand;
import template.modules.admin.appl.query.glossary.GlossaryItemQuery;
import template.modules.admin.domain.model.glossary.GlossaryItem;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

/**
 * 祝日コントローラー
 */
@Controller
@AllArgsConstructor
@RequestMapping(path = {"/admin/glossary",})
public class AdminGlossaryController {

    private final GlossaryItemQuery glossaryItemQuery;
    private final CreateItemCommand createItemCommand;
    private final UpdateItemCommand updateItemCommand;
    private final DropItemCommand dropItemCommand;

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
        createItemCommand.execute(glossaryForm.convertToInsertModel());
        return "redirect:/admin/glossary";

    }

    /**
     * /admin/glossary/updateForm 変更入力フォームGET時のエンドポイント.
     *
     * @param id    変更対象の祝日ID
     * @param model モデル
     * @return テンプレート
     */
    @GetMapping(path = "/editForm")
    public String editForm(@RequestParam(name = "glossaryItemId") Long id, Model model) {
        GlossaryItem glossaryItem = glossaryItemQuery.findOneById(SnowflakeId.of(id));
        GlossaryItemForm glossaryItemForm = GlossaryItemForm.reconstruct(glossaryItem);
        model.addAttribute("form", glossaryItemForm);
        return "admin/glossary/editForm";

    }

    /**
     * /admin/glossary/update POST時のエンドポイント.
     *
     * @param glossaryItemForm 入力フォーム
     * @return テンプレート
     */
    @PostMapping(path = "/update")
    public String update(@ModelAttribute(name = "form") GlossaryItemForm glossaryItemForm) {
        updateItemCommand.execute(glossaryItemForm.convertToUpdateModel());
        return "redirect:/admin/glossary";

    }

    /**
     * /admin/holiday/update POST時のエンドポイント.
     *
     * @param id 削除したい祝日ID
     * @return テンプレート
     */
    @PostMapping(path = "/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        dropItemCommand.execute(SnowflakeId.of(id));
        return "redirect:/admin/glossary";

    }

}
