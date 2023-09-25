package template.modules.admin.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Adminのダッシュボード用path
 */
@Controller
@RequestMapping(path = {"/admin",})
public class AdminIndexController {
    /**
     * get mapping.
     *
     * @return テンプレート
     */
    @GetMapping
    public String get() {
        return "admin/index";

    }
}
