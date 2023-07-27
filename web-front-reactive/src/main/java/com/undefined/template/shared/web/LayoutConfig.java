package com.undefined.template.shared.web;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LayoutConfig {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
        
    }
}
