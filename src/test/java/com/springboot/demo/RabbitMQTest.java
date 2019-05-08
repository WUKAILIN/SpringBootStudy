package com.springboot.demo;

import com.springboot.demo.mq.rabbitmq.config.RabbitFanoutConfig;
import com.springboot.demo.mq.rabbitmq.config.RabbitTopicConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitMQTest {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void testDirectMessage()
    {
        rabbitTemplate.convertAndSend("rabbitmq-queue","messageByDirect2");
    }
    @Test
    public void testFanoutMessage()
    {
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.fanoutExchangeName,null,"hello fanout");
    }
    @Test
    public void testTopicMessage()
    {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.topicExchangeName,"rabbitMQ.message","rabbitMqQueue消息");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.topicExchangeName,"activeMQ.message","activeMqQueue消息");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.topicExchangeName,"rabbitMQ.mq","分别路由至rabbitMqQueue和mqQueue消息");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.topicExchangeName,"activeMQ.mq","分别路由至activeMqQueue和mqQueue消息");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.topicExchangeName,"mq.message","路由至mqQueue消息");
    }
}
