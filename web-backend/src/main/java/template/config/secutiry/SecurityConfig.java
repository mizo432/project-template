package template.config.secutiry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * セキュリティ構成
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    // @formatter:off
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/actuator/**").permitAll()
                        .requestMatchers("/actuator").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/image/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
        ).formLogin((formLogin)-> formLogin
                .loginPage("/login")
                .failureForwardUrl("/login-error")

        );
        return http.build();
    }
    // @formatter:on
}
