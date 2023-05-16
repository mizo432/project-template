package com.undecided.projectTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.undecided")
public class WebFront2 {

    public static void main(String[] args) {
        SpringApplication.run(WebFront2.class, args);

    }

}
