package template.shared.presentation.web;

import com.undecided.gfw.web.logging.TraceLoggingInterceptor;
import com.undecided.gfw.web.token.transaction.TransactionTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfigSupport extends
        WebMvcConfigurationSupport {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceLoggingInterceptor());
        registry.addInterceptor(transactionTokenInterceptor());

    }

    @Bean
    protected HandlerInterceptor transactionTokenInterceptor() {
        return new TransactionTokenInterceptor();

    }

    @Bean
    protected HandlerInterceptor traceLoggingInterceptor() {
        return new TraceLoggingInterceptor();

    }

}
