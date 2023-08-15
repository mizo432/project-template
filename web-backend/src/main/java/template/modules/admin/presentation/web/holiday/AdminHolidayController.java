package template.modules.admin.presentation.web.holiday;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import template.modules.admin.appl.query.holiday.HolidayQuery;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = {"/admin/holiday",})
public class AdminHolidayController {

    private final HolidayQuery holidayQuery;

    @GetMapping
    public String get(Model model) {
        List<HolidayForm> holidayForm = HolidayForm.HolidayFormList.reconstruct(holidayQuery.selectAll());
        model.addAttribute("formList", holidayForm);
        return "admin/holiday/list";

    }

}
