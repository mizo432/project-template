package org.venusPj.projectTemplate.modules.resource.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductsController {


    @GetMapping
    String getAll() {

        return "index";

    }

}
