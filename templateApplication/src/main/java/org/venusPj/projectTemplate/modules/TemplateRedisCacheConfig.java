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
import org.venusPj.projectTemplate.shared.cache.CacheObjectMapperResolver;

/**
 * BackboneSharedApplication向けキャッシュ設定
 */
@Configuration
@EnableCaching
class TemplateRedisCacheConfig {

    private final CacheObjectMapperResolver cacheObjectMapperResolver;


    public TemplateRedisCacheConfig(CacheObjectMapperResolver cacheObjectMapperResolver) {
        this.cacheObjectMapperResolver = cacheObjectMapperResolver;
    }

    private RedisCacheConfiguration cacheConfiguration(Duration duration) {
        ObjectMapper objectMapper = cacheObjectMapperResolver.objectMapper();
        return RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(duration)
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
            // ３．actorCacheという名称のキャッシュに対し、有効期限を設定する
            .withCacheConfiguration("actor", cacheConfiguration(Duration.ofHours(24)))
            // productCacheという名称のキャッシュに対し、有効期限を設定する
            .withCacheConfiguration("project", cacheConfiguration(Duration.ofMinutes(5L)))
        ;

        return builder.build();
    }

}
