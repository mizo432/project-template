package org.venusPj.projectTemplate.modules;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class TemplateMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
            .addResourceLocations("classpath:/static/")
            .setCachePeriod(604800)
            .resourceChain(true) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new VersionResourceResolver()
                    .addContentVersionStrategy("/**/**.css")
                    .addContentVersionStrategy("/**/**.js")
                    .addContentVersionStrategy("/**/*.png")
                // コンテンツデータのMD5ハッシュ値によるバージョニング機能の有効化
            );
        registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/")
            .resourceChain(true) // プロダクション環境ではtrue/開発環境ではfalseがおすすめ
            .addResolver(new EncodedResourceResolver());

    }

}
