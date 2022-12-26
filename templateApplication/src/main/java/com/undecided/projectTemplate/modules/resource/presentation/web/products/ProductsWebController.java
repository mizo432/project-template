package com.undecided.projectTemplate.modules.resource.presentation.web.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductsWebController {


    @GetMapping
    String getAll() {

        return "index";

    }

}
