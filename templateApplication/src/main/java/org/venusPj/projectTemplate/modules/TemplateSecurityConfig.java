package org.venusPj.projectTemplate.modules;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.support.RequestDataValueProcessor;
import org.venusPj.gfw.web.mvc.support.CompositeRequestDataValueProcessor;
import org.venusPj.gfw.web.token.transaction.TransactionTokenRequestDataValueProcessor;

@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(SecurityAutoConfiguration.class)
public class TemplateSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher("/actuator/**");
        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        return http.build();
    }

    @Bean
    public RequestDataValueProcessor requestDataValueProcessor() {
        return new CompositeRequestDataValueProcessor(
            //        new CsrfRequestDataValueProcessor(),
            new TransactionTokenRequestDataValueProcessor());
    }
}
