package org.venusPj.projectTemplate.shared.precentation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.RequestDataValueProcessor;
import org.terasoluna.gfw.web.logging.TraceLoggingInterceptor;
import org.terasoluna.gfw.web.mvc.support.CompositeRequestDataValueProcessor;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenInterceptor;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenRequestDataValueProcessor;

@Configuration
public class TemplateWebMvcConfig implements WebMvcConfigurer {

    @Bean
    public TraceLoggingInterceptor traceLoggingInterceptor() {
        return new TraceLoggingInterceptor();
    }

    @Bean
    public TransactionTokenInterceptor transactionTokenInterceptor() {
        return new TransactionTokenInterceptor();
    }


    @Bean(name = "requestDataValueProcessor")
    @Primary
    public RequestDataValueProcessor requestDataValueProcessor() {
        return new CompositeRequestDataValueProcessor(
            new CsrfRequestDataValueProcessor(),
            new TransactionTokenRequestDataValueProcessor());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceLoggingInterceptor());
        registry.addInterceptor(transactionTokenInterceptor());
    }
}
