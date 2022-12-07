package org.venusPj.projectTemplate.modules;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.venusPj.gfw.security.web.logging.UserIdMDCPutFilter;
import org.venusPj.gfw.web.logging.mdc.MDCClearFilter;
import org.venusPj.gfw.web.logging.mdc.XTrackMDCPutFilter;

@Configuration

public class TemplateApplicationConfig {


    @Bean
    public XTrackMDCPutFilter xTrackMDCPutFilter() {
        return new XTrackMDCPutFilter();
    }

    @Bean
    public UserIdMDCPutFilter userIdMDCPutFilter() {
        return new UserIdMDCPutFilter();

    }

    @Bean
    public MDCClearFilter mDCClearFilter() {
        return new MDCClearFilter();

    }


}
