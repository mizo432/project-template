package com.undecided.projectTemplate.modules;

import com.undecided.gfw.web.mvc.support.CompositeRequestDataValueProcessor;
import com.undecided.gfw.web.token.transaction.TransactionTokenRequestDataValueProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

@Configuration
@AutoConfigureAfter(SecurityAutoConfiguration.class)
public class TemplateSecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateSecurityConfig.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher("/actuator/**");
        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        return http.build();
    }

    @Bean
    RequestDataValueProcessor requestDataValueProcessor() {
        LOGGER.debug("#requestDataValueProcessor()");
        return new CompositeRequestDataValueProcessor(
            new CsrfRequestDataValueProcessor(),
            new TransactionTokenRequestDataValueProcessor());
    }
}
