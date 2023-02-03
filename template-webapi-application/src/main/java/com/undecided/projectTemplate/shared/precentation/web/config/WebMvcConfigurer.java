package com.undecided.projectTemplate.shared.precentation.web.config;

import com.undecided.gfw.web.logging.TraceLoggingInterceptor;
import com.undecided.gfw.web.logging.mdc.MDCClearFilter;
import com.undecided.gfw.web.logging.mdc.XTrackMDCPutFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfigurer implements
    org.springframework.web.servlet.config.annotation.WebMvcConfigurer {

//    private static final Logger LOG = LoggerFactory.getLogger(TemplateMvcConfig.class);

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); // デフォルトサーブレットへの転送機能を有効化
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/css/**")
            .addResourceLocations("classpath:/static/css/")
            .setCachePeriod(604800)
            .resourceChain(false) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/*.css")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/images/**")
            .addResourceLocations("classpath:/static/images/")
            .setCachePeriod(604800)
            .resourceChain(false) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/*.png")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/img/**")
            .addResourceLocations("classpath:/static/img/")
            .setCachePeriod(604800)
            .resourceChain(false) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/*.png", "/**/*.jpg", "/**/*.svg")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/js/**")
            .addResourceLocations("classpath:/static/js/")
            .setCachePeriod(604800)
            .resourceChain(false) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/*.js")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/")
            .setCachePeriod(604800)
            .resourceChain(false) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/*.html", "/**/*.ico")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/")
            .resourceChain(false) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TraceLoggingInterceptor());
    }
}
