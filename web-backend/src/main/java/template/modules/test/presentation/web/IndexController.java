package template.modules.test.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/", "/index"})
public class IndexController {
    @GetMapping()
    public String get(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!!");
        return "fragments/fragments";
    }
}
