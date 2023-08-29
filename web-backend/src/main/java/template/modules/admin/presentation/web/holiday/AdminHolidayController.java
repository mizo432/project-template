package template.modules.admin.presentation.web.holiday;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import template.modules.admin.appl.command.holiday.DeleteHolidayCommand;
import template.modules.admin.appl.command.holiday.InsertHolidayCommand;
import template.modules.admin.appl.command.holiday.UpdateHolidayCommand;
import template.modules.admin.appl.query.holiday.HolidayQuery;
import template.modules.admin.domain.model.holiday.Holiday;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

/**
 * 祝日コントローラー
 */
@Controller
@AllArgsConstructor
@RequestMapping(path = {"/admin/holiday",})
public class AdminHolidayController {

    private final HolidayQuery holidayQuery;

    private final InsertHolidayCommand insertHolidayCommand;
    private final UpdateHolidayCommand updateHolidayCommand;
    private final DeleteHolidayCommand deleteHolidayCommand;

    /**
     * /admin/holiday GET時のエンドポイント.
     *
     * @param model モデル
     * @return テンプレート
     */
    @GetMapping
    public String get(Model model) {
        List<HolidayForm> formList = HolidayForm.HolidayFormList.reconstruct(holidayQuery.selectAll());
        model.addAttribute("formList", formList);
        return "admin/holiday/list";

    }

    /**
     * /admin/holiday/insertForm 新規入力フォームGET時のエンドポイント.
     *
     * @param model モデル
     * @return テンプレート
     */
    @GetMapping(path = "/insertForm")
    public String insertForm(Model model) {
        HolidayForm holidayForm = new HolidayForm();
        model.addAttribute("form", holidayForm);
        return "admin/holiday/insertForm";

    }

    /**
     * /admin/holiday/insert POST時のエンドポイント.
     *
     * @param holidayForm 入力フォーム
     * @return テンプレート
     */
    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute(name = "form") HolidayForm holidayForm) {
        insertHolidayCommand.execute(holidayForm.convertToInsertModel());
        return "redirect:/admin/holiday";

    }


    /**
     * /admin/holiday/updateForm 変更入力フォームGET時のエンドポイント.
     *
     * @param id    変更対象の祝日ID
     * @param model モデル
     * @return テンプレート
     */
    @GetMapping(path = "/editForm")
    public String editForm(@RequestParam(name = "holidayId") Long id, Model model) {
        Holiday holiday = holidayQuery.findOneBy(SnowflakeId.of(id));
        HolidayForm holidayForm = HolidayForm.reconstruct(holiday);
        model.addAttribute("form", holidayForm);
        return "admin/holiday/editForm";

    }

    /**
     * /admin/holiday/update POST時のエンドポイント.
     *
     * @param holidayForm 入力フォーム
     * @return テンプレート
     */
    @PostMapping(path = "/update")
    public String update(@ModelAttribute(name = "form") HolidayForm holidayForm) {
        updateHolidayCommand.execute(holidayForm.convertToUpdateModel());
        return "redirect:/admin/holiday";

    }

    /**
     * /admin/holiday/update POST時のエンドポイント.
     *
     * @param id 削除したい祝日ID
     * @return テンプレート
     */
    @PostMapping(path = "/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        deleteHolidayCommand.execute(SnowflakeId.of(id));
        return "redirect:/admin/holiday";

    }

}
