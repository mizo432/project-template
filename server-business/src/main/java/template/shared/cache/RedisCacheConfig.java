package template.shared.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.time.Duration;

/**
 * BackboneSharedApplication向けキャッシュ設定
 */
@Configuration
@EnableCaching
class RedisCacheConfig {

    private final ObjectMapper objectMapper;


    public RedisCacheConfig() {
        this.objectMapper = createObjectMapper();
    }

    private ObjectMapper createObjectMapper() {
        return new ObjectMapper();
    }

    private RedisCacheConfiguration cacheConfiguration(Duration duration) {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(duration)
                .disableCachingNullValues()
                .serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(
                        SerializationPair.fromSerializer(
                                new GenericJackson2JsonRedisSerializer(objectMapper)));
    }

    @Bean(name = "redisCacheManager")
    @Primary
    public CacheManager redisCacheManager(RedisConnectionFactory fac) {
        // １．キャッシュビルダーからキャッシュを作成する
        RedisCacheManagerBuilder builder =
                RedisCacheManager.builder(fac);
        builder
                .cacheDefaults(
                        // ２．デフォルトのキャッシュ有効期限を設定する
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)))
                // ３．actorという名称のキャッシュに対し、有効期限を設定する
                .withCacheConfiguration("actor", cacheConfiguration(Duration.ofHours(24)))
                // projectという名称のキャッシュに対し、有効期限を設定する
                .withCacheConfiguration("project", cacheConfiguration(Duration.ofMinutes(5L)))
                // projectという名称のキャッシュに対し、有効期限を設定する
                .withCacheConfiguration("business", cacheConfiguration(Duration.ofMinutes(5L)))
        ;

        return builder.build();
    }

}
