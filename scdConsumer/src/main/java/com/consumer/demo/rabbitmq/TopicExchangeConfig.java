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
    /**注册api.core的队列**/
    @Bean
    public Queue coreQueue() {
        return new Queue("api.core");
    }
    /**注册api.payment的队列**/
    @Bean
    public Queue paymentQueue() {
        return new Queue("api.payment");
    }
    /**注册api.core的交换机**/
    @Bean
    public TopicExchange coreExchange() {
        return new TopicExchange("coreExchange");
    }
    /**注册api.payment的交换机**/
    @Bean
    public TopicExchange paymentExchange() {
        return new TopicExchange("paymentExchange");
    }
    /**指定队列(api.core)到交换机的路由规则**/
    @Bean
    public Binding bindingCoreExchange(Queue coreQueue, TopicExchange coreExchange) {
        //.*只能向后匹配一层 绑定队列coreQueue到交换机coreExchange路由api.core.*
        return BindingBuilder.bind(coreQueue).to(coreExchange).with("api.core.*");
    }
    /**指定队列(api.payment)到交换机的路由规则**/
    @Bean
    public Binding bindingPaymentExchange(Queue paymentQueue, TopicExchange paymentExchange) {
        //.#能向后匹配多层
        return BindingBuilder.bind(paymentQueue).to(paymentExchange).with("api.payment.#");
    }
}
