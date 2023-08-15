package template.modules.admin.presentation.web.holiday;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/admin/holiday",})
public class AdminHolidayController {

    @GetMapping
    public String get() {
        return "admin/holiday/list";

    }

}
