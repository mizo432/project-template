package com.undecided.projectTemplate.modules.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index2")
public class Index2Controller {

    @GetMapping
    public String get() {
        return "index2";
    }

}
