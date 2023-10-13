package template.shared.presentation.web.session;

import com.undecided.gfw.web.logging.HttpSessionEventLoggingListener;
import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession
public class BackendSessionConfig {

    @Bean
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionEventLoggingListener();
    }

    @Bean
    public HttpSessionAttributeListener httpSessionAttributeListener() {
        return new HttpSessionEventLoggingListener();
    }

    @Bean
    public HttpSessionActivationListener httpSessionActivationListener() {
        return new HttpSessionEventLoggingListener();
    }
}
