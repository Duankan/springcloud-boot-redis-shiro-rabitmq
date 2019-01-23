package com.provider.demo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
/**
 * redis使用模板
 */
@Configuration
public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(jedisConnectionFactory());//设置连接池
        template.setKeySerializer(new StringRedisSerializer());//设置key序列化器
        template.setValueSerializer(new RedisObjectSerializer());
//        template.setValueSerializer(new RedisSerializer2());//设置value序列化器
        return template;
    }
}
