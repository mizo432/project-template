package org.venusPj.projectTemplate;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
}
