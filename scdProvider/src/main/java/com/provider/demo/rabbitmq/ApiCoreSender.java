package com.provider.demo.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * api.core发送者：通过交换机生产消息到队列
 */
@Component
public class ApiCoreSender {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void user(String msg){
        logger.info("api.core.user send message: "+msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user", msg);
    }
    public void userQuery(String msg){
        logger.info("api.core.user.query send message: "+msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user.query", msg);
    }
}
