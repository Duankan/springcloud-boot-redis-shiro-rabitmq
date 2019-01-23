package com.consumer.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 交换机配置类
 */
@Configuration
public class TopicExchangeConfig {
    @Bean
    public Queue coreQueue() {
        return new Queue("api.core");
    }
    @Bean
    public Queue paymentQueue() {
        return new Queue("api.payment");
    }
    @Bean
    public TopicExchange coreExchange() {
        return new TopicExchange("coreExchange");
    }
    @Bean
    public TopicExchange paymentExchange() {
        return new TopicExchange("paymentExchange");
    }
    @Bean
    public Binding bindingCoreExchange(Queue coreQueue, TopicExchange coreExchange) {
        //.*只能向后匹配一层
        return BindingBuilder.bind(coreQueue).to(coreExchange).with("api.core.*");
    }
    @Bean
    public Binding bindingPaymentExchange(Queue paymentQueue, TopicExchange paymentExchange) {
        //.#能向后匹配多层
        return BindingBuilder.bind(paymentQueue).to(paymentExchange).with("api.payment.#");
    }
}
