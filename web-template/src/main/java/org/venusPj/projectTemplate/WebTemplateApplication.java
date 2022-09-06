package org.venusPj.projectTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
public class WebTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebTemplateApplication.class, args);

    }
}