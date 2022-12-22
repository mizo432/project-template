package org.venusPj.projectTemplate.modules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.venusPj.gfw.security.web.logging.UserIdMDCPutFilter;
import org.venusPj.gfw.web.logging.TraceLoggingInterceptor;
import org.venusPj.gfw.web.logging.mdc.MDCClearFilter;
import org.venusPj.gfw.web.logging.mdc.XTrackMDCPutFilter;

@Configuration
@EnableWebMvc
public class TemplateMvcConfig implements WebMvcConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(TemplateMvcConfig.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
            .addResourceLocations("classpath:/static/css/")
            .setCachePeriod(604800)
            .resourceChain(true) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/*.css")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/images/**")
            .addResourceLocations("classpath:/static/images/")
            .setCachePeriod(604800)
            .resourceChain(true) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/*.png")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/img/**")
            .addResourceLocations("classpath:/static/img/")
            .setCachePeriod(604800)
            .resourceChain(true) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/*.png", "/**/*.jpg")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/js/**")
            .addResourceLocations("classpath:/static/js/")
            .setCachePeriod(604800)
            .resourceChain(true) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/*.js")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/")
            .setCachePeriod(604800)
            .resourceChain(true) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/*.html", "/**/*.ico")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/")
            .resourceChain(true) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new EncodedResourceResolver());

    }

    @Bean
    public MDCClearFilter mDCClearFilter() {
        return new MDCClearFilter();

    }

    @Bean
    public XTrackMDCPutFilter xTrackMDCPutFilter() {
        return new XTrackMDCPutFilter();

    }

    @Bean
    public UserIdMDCPutFilter userIdMDCPutFilter() {
        return new UserIdMDCPutFilter();

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TraceLoggingInterceptor());
    }
}