package com.springboot.demo.mq.rabbitmq.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceive {
    /**
     *消费队列名为rabbitmq-queue的消息
     * @param message：消息内容
     */
    @RabbitListener(queues = "rabbitmq-queue")
    public void directReceive(String message)
    {
        System.out.println("DirectReceive-----------"+message);
    }

}
