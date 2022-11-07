package org.venusPj.projectTemplate.modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Duration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * BackboneSharedApplication向けキャッシュ設定
 */
@Configuration
@EnableCaching
class TemplateRedisCacheConfig {

/*
    private ObjectMapper objectMapper() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

        FilterProvider filters = new SimpleFilterProvider();

        ObjectMapper resultMapper = builder.filters(filters).build();
        resultMapper.registerModule(new JavaTimeModule());
        resultMapper.setSerializationInclusion(Include.NON_NULL);
        resultMapper.activateDefaultTyping(resultMapper.getPolymorphicTypeValidator(),
            DefaultTyping.NON_FINAL, As.PROPERTY);

        return resultMapper;

    }
*/

    @Bean
    public RedisCacheConfiguration cacheConfiguration(ObjectMapper objectMapper) {
        return RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(60))
            .disableCachingNullValues()
            .serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()))
            .serializeValuesWith(
                SerializationPair.fromSerializer(
                    new GenericJackson2JsonRedisSerializer(objectMapper)));
    }

    @Bean(name = "templateRedisCacheManager")
    @Primary
    public CacheManager redisCacheManager(RedisConnectionFactory fac) {
        // １．キャッシュビルダーからキャッシュを作成する
        RedisCacheManagerBuilder builder =
            RedisCacheManager.builder(fac);
        builder
            .cacheDefaults(
                // ２．デフォルトのキャッシュ有効期限を設定する
                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)))
            // ３．cache1という名称のキャッシュに対し、有効期限を設定する
            .withCacheConfiguration("actorCache",
                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(24)))
            // ３．cache2という名称のキャッシュに対し、有効期限を設定する
            .withCacheConfiguration("productCache",
                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(24)))
        ;

        return builder.build();
    }

}
