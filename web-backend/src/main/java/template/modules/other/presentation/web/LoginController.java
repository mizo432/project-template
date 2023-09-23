package template.modules.other.presentation.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/login"})
@Slf4j
public class LoginController {
    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";

    }

    @PostMapping
    public String login(@ModelAttribute LoginForm loginForm) {
        log.debug(loginForm.toString());

        return "login";

    }

}
