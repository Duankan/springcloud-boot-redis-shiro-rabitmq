package com.provider.demo.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 */
@Component
public class PaymentNotifySender {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender(String msg){
        logger.info("notify.payment send message: "+msg);
        rabbitTemplate.convertAndSend("notify.payment", msg);
    }
}
