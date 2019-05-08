package com.springboot.demo.mq.rabbitmq.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceive {
    @RabbitListener(queues = "activeMQQueue")
    public void activeMqReceive(String message)
    {
        System.out.println("ActiveMQReceive--------"+message);
    }
    @RabbitListener(queues = "rabbitMQQueue")
    public void rabbitMqReceive(String message)
    {
        System.out.println("RabbitMQReceive--------"+message);
    }
    @RabbitListener(queues = "mqQueue")
    public void mqReceive(String message)
    {
        System.out.println("mqReceive--------"+message);
    }
}
