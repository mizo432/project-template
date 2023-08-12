package template.modules.test.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/hello")
public class HelloController {
    @GetMapping()
    public String hello(Model model) {
        model.addAttribute("message", "Hello Thymeleaf!!");
        return "fragments/fragments";
    }
}
