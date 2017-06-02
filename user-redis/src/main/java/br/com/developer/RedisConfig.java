package br.com.developer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableRedisRepositories(basePackages = { "br.com.developer" })
public class RedisConfig {

    @Bean
    RedisConnectionFactory connectionFactory() {
        try {

            final JedisPoolConfig poolConfig = new JedisPoolConfig();
            poolConfig.setMaxTotal(10);
            poolConfig.setMaxIdle(5);
            poolConfig.setMinIdle(1);
            poolConfig.setTestOnBorrow(true);
            poolConfig.setTestOnReturn(true);
            poolConfig.setTestWhileIdle(true);
            poolConfig.setMaxWaitMillis(10 * 1000);
            final JedisConnectionFactory cf = new JedisConnectionFactory(poolConfig);
            cf.setHostName("172.17.0.2");
            // cf.setHostName("localhost");
            cf.setPort(6379);

            // cf.setPassword("");
            cf.setUsePool(true);
            return cf;

        } catch (final Exception e) {
            e.printStackTrace();
            /*
             * Usually a bad practice to catch generic exceptions, but in this
             * case the ConnectionFactory creation could give an error for
             * various reasons.
             */
            return null;
        }
    }

    @Bean
    RedisTemplate<?, ?> redisTemplate(final RedisConnectionFactory connectionFactory) {
        final RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
        template.setConnectionFactory(connectionFactory);

        return template;
    }
}
