package com.undecided.template.shared.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.authentication.preauth.x509.SubjectDnX509PrincipalExtractor;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;
import reactor.core.publisher.Mono;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        SubjectDnX509PrincipalExtractor principalExtractor =
                new SubjectDnX509PrincipalExtractor();

        principalExtractor.setSubjectDnRegex("OU=(.*?)(?:,|$)");

        ReactiveAuthenticationManager authenticationManager = authentication -> {
            authentication.setAuthenticated("Trusted Org Unit".equals(authentication.getName()));
            return Mono.just(authentication);
        };

        http
                .x509(x509 -> x509
                        .principalExtractor(principalExtractor)
                        .authenticationManager(authenticationManager)
                )
                .authorizeExchange(exchanges -> exchanges
                        .matchers(
                                new PathPatternParserServerWebExchangeMatcher("/css/**")).permitAll()
                        .matchers(
                                new PathPatternParserServerWebExchangeMatcher("/js/**")).permitAll()
                        .matchers(
                                new PathPatternParserServerWebExchangeMatcher("/img/**")).permitAll()
                        .matchers(
                                new PathPatternParserServerWebExchangeMatcher("/actuator/**")).permitAll()
                        .matchers(
                                new PathPatternParserServerWebExchangeMatcher("/actuator")).permitAll()
                        .anyExchange().permitAll()
                );
        return http.build();
    }
}
