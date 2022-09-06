package org.venusPj.projectTemplate.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
@EnableRedisHttpSession
public class WebTemplateSessionConfig {

    private ObjectMapper objectMapper() {

        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

        FilterProvider filters = new SimpleFilterProvider().setFailOnUnknownId(false);
        ObjectMapper resultMapper = builder.filters(filters).build();
        resultMapper.registerModule(new JavaTimeModule());
        resultMapper.setSerializationInclusion(Include.NON_NULL);
        resultMapper.activateDefaultTyping(resultMapper.getPolymorphicTypeValidator(),
            DefaultTyping.NON_FINAL, As.PROPERTY);

        return resultMapper;

    }

    public WebTemplateSessionConfig() {
    }

    @Bean
    public CookieSerializer httpSessionIdResolver() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        //
        cookieSerializer.setSameSite(null);
        return cookieSerializer;

    }

    @Bean
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer(objectMapper());


    }
}
