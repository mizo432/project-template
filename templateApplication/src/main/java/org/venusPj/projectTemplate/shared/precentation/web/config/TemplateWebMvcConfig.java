package org.venusPj.projectTemplate.shared.precentation.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.terasoluna.gfw.web.exception.ExceptionLoggingFilter;
import org.terasoluna.gfw.web.exception.HandlerExceptionResolverLoggingInterceptor;
import org.terasoluna.gfw.web.logging.TraceLoggingInterceptor;

@Configuration
public class TemplateWebMvcConfig implements WebMvcConfigurer {

    @Bean
    public TraceLoggingInterceptor traceLoggingInterceptor() {
        return new TraceLoggingInterceptor();
    }

/*
    @Bean
    public TransactionTokenInterceptor transactionTokenInterceptor() {
        return new TransactionTokenInterceptor(new TokenStringGenerator(),
            new TransactionTokenInfoStore(), new HttpSessionTransactionTokenStore());
    }
*/


    /*
        @Bean(name = "requestDataValueProcessor")
        @Primary
        public RequestDataValueProcessor requestDataValueProcessor() {
            return new CompositeRequestDataValueProcessor(
                new CsrfRequestDataValueProcessor(),
                new TransactionTokenRequestDataValueProcessor());
        }
    */
    @Bean
    public HandlerExceptionResolverLoggingInterceptor getHandlerExceptionResolverLoggingInterceptor() {
        return new HandlerExceptionResolverLoggingInterceptor();

    }

    @Bean
    public ExceptionLoggingFilter getExceptionLoggingFilter() {
        return new ExceptionLoggingFilter();

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceLoggingInterceptor());
//        registry.addInterceptor(transactionTokenInterceptor());
    }

}
