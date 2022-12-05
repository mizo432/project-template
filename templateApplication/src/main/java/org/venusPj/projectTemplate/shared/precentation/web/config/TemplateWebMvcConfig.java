package org.venusPj.projectTemplate.shared.precentation.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.venusPj.gfw.web.loging.TraceLoggingInterceptor;
import org.venusPj.gfw.web.token.transaction.TransactionTokenInterceptor;

@Configuration
public class TemplateWebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceLoggingInterceptor());
        registry.addInterceptor(transactionTokenInterceptor());

    }

    private HandlerInterceptor transactionTokenInterceptor() {
        return new TransactionTokenInterceptor();
    }

    /**
     * @return
     */
    private HandlerInterceptor traceLoggingInterceptor() {
        return new TraceLoggingInterceptor();
        
    }

}
