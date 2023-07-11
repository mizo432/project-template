package com.undefined.template.modules.bar.web.bar;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/bar/index1")
public class Index1Controller {

    @RequestMapping
    public String index() {
        return "bar/index1";
    }

}
