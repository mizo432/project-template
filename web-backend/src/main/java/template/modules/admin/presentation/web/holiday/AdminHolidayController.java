package template.modules.admin.presentation.web.holiday;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import template.modules.admin.appl.command.holiday.DeleteHolidayCommand;
import template.modules.admin.appl.command.holiday.InsertHolidayCommand;
import template.modules.admin.appl.query.holiday.HolidayQuery;
import template.shared.entity.id.SnowflakeId;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = {"/admin/holiday",})
public class AdminHolidayController {

    private final HolidayQuery holidayQuery;

    private final InsertHolidayCommand insertHolidayCommand;
    private final DeleteHolidayCommand deleteHolidayCommand;

    @GetMapping
    public String get(Model model) {
        List<HolidayForm> formList = HolidayForm.HolidayFormList.reconstruct(holidayQuery.selectAll());
        model.addAttribute("formList", formList);
        return "admin/holiday/list";

    }

    @GetMapping(path = "/insertForm")
    public String insertForm(Model model) {
        HolidayForm holidayForm = new HolidayForm();
        model.addAttribute("form", holidayForm);
        return "admin/holiday/insertForm";

    }

    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute(name = "form") HolidayForm holidayForm, Model model) {
        insertHolidayCommand.execute(holidayForm.convertToInsertModel());
        return "redirect:/admin/holiday";

    }

    @PostMapping(path = "/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        deleteHolidayCommand.execute(SnowflakeId.of(id));
        return "redirect:/admin/holiday";

    }

}
