package com.undecided.projectTemplate.modules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.undecided.projectTemplate")
public class TemplateWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateWebApplication.class, args);
    }

}
