package template.modules.admin.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/admin",})
public class AdminIndexController {
    @GetMapping
    public String get() {
        return "admin/index";

    }
}
