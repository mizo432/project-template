package com.undecided.projectTemplate.shared.actuator;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.web.exchanges.HttpExchange;
import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorHttpExchangesConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(ActuatorHttpExchangesConfig.class);

    private static final int EXCHANGE_CAPACITY = 2000;

    private final ObjectMapper objectMapper;

    public ActuatorHttpExchangesConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    public HttpExchangeRepository httpExchangeRepository() {
        var repository = new InMemoryHttpExchangeRepository() {
            @SneakyThrows
            @Override
            public void add(HttpExchange exchange) {
                LOGGER.debug(objectMapper.writeValueAsString(exchange));
                super.add(exchange);
            }
        };
        repository.setCapacity(EXCHANGE_CAPACITY);
        return repository;
    }

}
