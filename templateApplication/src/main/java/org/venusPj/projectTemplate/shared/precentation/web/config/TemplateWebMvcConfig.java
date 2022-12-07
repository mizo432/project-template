package org.venusPj.projectTemplate.shared.precentation.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.venusPj.gfw.web.logging.TraceLoggingInterceptor;
import org.venusPj.gfw.web.token.transaction.TransactionTokenInterceptor;

@Configuration
public class TemplateWebMvcConfig extends WebMvcConfigurationSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateWebMvcConfig.class);

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

    private HandlerInterceptor traceLoggingInterceptor() {
        return new TraceLoggingInterceptor();

    }

}
