package com.handson.labs.graphql.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.handson.labs.graphql.entity.*;

@Configuration
public class RedisCacheConfig {

    @Bean
    public RedisTemplate<String, Author> authorRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Author> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Author.class));
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Author.class));
        template.setDefaultSerializer(RedisSerializer.json());
        return template;
    }

    @Bean
    public RedisTemplate<String, Book> bookRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Book> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Book.class));
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Book.class));
        template.setDefaultSerializer(RedisSerializer.json());
        return template;
    }

    @Bean
    public RedisTemplate<String, Publisher> publisherRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Publisher> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Publisher.class));
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Publisher.class));
        template.setDefaultSerializer(RedisSerializer.json());
        return template;
    }

    @Bean
    public RedisTemplate<String, User> userRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, User> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        template.setDefaultSerializer(RedisSerializer.json());
        return template;
    }

    @Bean
    public RedisTemplate<String, Review> reviewRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Review> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Review.class));
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Review.class));
        template.setDefaultSerializer(RedisSerializer.json());
        return template;
    }

    @Bean
    public RedisTemplate<String, Category> categoryRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Category> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Category.class));
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Category.class));
        template.setDefaultSerializer(RedisSerializer.json());
        return template;
    }

    @Bean
    public RedisTemplate<String, Orders> ordersRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Orders> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Orders.class));
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Orders.class));
        return template;
    }


}
