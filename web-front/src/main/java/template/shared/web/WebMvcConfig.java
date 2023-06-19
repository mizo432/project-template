package template.shared.web;

import com.undecided.gfw.web.logging.TraceLoggingInterceptor;
import com.undecided.gfw.web.logging.mdc.MDCClearFilter;
import com.undecided.gfw.web.logging.mdc.XTrackMDCPutFilter;
import com.undecided.gfw.web.token.transaction.TransactionTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public MDCClearFilter mDCClearFilter() {
        return new MDCClearFilter();

    }

    @Bean
    public XTrackMDCPutFilter xTrackMDCPutFilter() {
        return new XTrackMDCPutFilter();

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TraceLoggingInterceptor());
        registry.addInterceptor(new TransactionTokenInterceptor());
    }

}
