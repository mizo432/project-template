package com.lissajous.taxiDispatcher.modules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
@EnableCaching
public class PrpjectTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxiDispatcherApplication.class, args);
    }

}
