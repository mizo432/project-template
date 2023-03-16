package com.undecided.projectTemplate.shared.actuator;

import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorHttpExchangesConfig {

    // private static final int EXCHANGE_CAPACITY = 2000;

//    @Bean
//    ObjectMapper om() {
//        return new ObjectMapper();
//            .registerModule(new JavaTimeModule())
//            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//    }

    @Bean
    public HttpExchangeRepository httpExchangeRepository() {
        // repository.setCapacity(EXCHANGE_CAPACITY);
        return new InMemoryHttpExchangeRepository();
    }
}
