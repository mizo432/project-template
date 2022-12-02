package org.venusPj.template.modules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.venusPj.template")
public class TemplateWebViewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateWebViewerApplication.class, args);
    }


}