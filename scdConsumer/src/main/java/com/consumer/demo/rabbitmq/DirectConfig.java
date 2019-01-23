package com.consumer.demo.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消费者配置类
 */
@Configuration
public class DirectConfig {
    @Bean
    public Queue paymentNotifyQueue() {
        return new Queue("notify.payment");
    }
}
