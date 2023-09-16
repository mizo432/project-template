package template.config.secutiry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/login-error").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                        .requestMatchers("/**").hasRole("USER")
//                        .requestMatchers("/**").permitAll()
                ).httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults()
 //       formLogin((formLogin)-> formLogin
 //               .loginPage("/login")
 //               .failureForwardUrl("/login-error")

        ).logout(logoutConfigurer->{
            logoutConfigurer
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true);
                });
        return http.build();
    }
    // @formatter:on

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users() {
        PasswordEncoder passwordEncoder = passwordEncoder();
        // The builder will ensure the passwords are encoded before saving in memory
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();
        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder.encode("password"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
