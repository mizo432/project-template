package com.undefined.template.modules.bar.web.bar;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/bar/index2")
public class Index2Controller {

    @RequestMapping
    public String index() {
        return "bar/index2";

    }

}
