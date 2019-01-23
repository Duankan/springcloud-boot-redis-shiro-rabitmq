package com.consumer.demo.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受者
 */
@Component
public class ApiReceive {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @RabbitHandler
    @RabbitListener(queues = "api.core")
    public void user(String msg){
        logger.info("api.core receive msg:"+msg);
    }
    @RabbitHandler
    @RabbitListener(queues = "api.payment")
    public void order(String msg){
        logger.info("api.payment.order receive message:"+msg);
    }
}
