package template;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@TestConfiguration
public class TestApplication {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new RedisConnectionFactory() {
            @Override
            public RedisConnection getConnection() {
                return null;
            }

            @Override
            public RedisClusterConnection getClusterConnection() {
                return null;
            }

            @Override
            public boolean getConvertPipelineAndTxResults() {
                return false;
            }

            @Override
            public RedisSentinelConnection getSentinelConnection() {
                return null;
            }

            @Override
            public DataAccessException translateExceptionIfPossible(final RuntimeException ex) {
                return null;
            }
        };
    }
}
