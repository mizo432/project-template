package com.undecided.projectTemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@TestConfiguration
class ApiTemplateWebApiApplicationTests {

    @Test
    void contextLoads() {
    }

}
