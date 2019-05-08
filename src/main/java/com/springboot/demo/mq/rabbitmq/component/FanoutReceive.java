package com.springboot.demo.mq.rabbitmq.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceive {
    /**
     *
     * @param message
     */
    @RabbitListener(queues = "fanoutqueue-one")
    public void receiveFanoutMessage1(String message)
    {
       System.out.println("ReceiveByFanoutQueueOne--------"+message);
    }
    @RabbitListener(queues = "fanoutqueue-two")
    public void receiveFanoutMessage2(String message)
    {
        System.out.println("ReceiveByFanoutQueueTwo--------"+message);
    }
}
