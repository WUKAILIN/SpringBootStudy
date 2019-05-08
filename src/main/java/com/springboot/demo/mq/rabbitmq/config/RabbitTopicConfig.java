package com.springboot.demo.mq.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {
    public final static String topicExchangeName="exchange-topic";
    /**
     * 创建TopicExchange,参数分别为topicExchangeName,重启是否依然有效(boolean),长期未使用是否自动删除(boolean)
     * @return TopicExchange
     */
    @Bean
    TopicExchange topicExchange()
    {

        return new TopicExchange(topicExchangeName,true,false);
    }

    /**
     * 创建名为activeMQ的队列
     * @return 队列
     */
    @Bean
    Queue activeMqQueue()
    {
        return new Queue("activeMQQueue");
    }

    /**
     * 创建名为rabbitMQ的队列
     * @return 队列
     */
    @Bean
    Queue rabbitMqQueue()
    {
        return new Queue("rabbitMQQueue");
    }

    /**
      创建名为mq的队列
     * @return 队列
     */
    @Bean
    Queue mqQueue()
    {
        return new Queue("mqQueue");
    }

    /**
     * 创建绑定对象，该绑定对象将队列名为activeMQ的队列与TopicExchange路由策略进行绑定，并指定路由规则
     * @return 绑定对象
     */
    @Bean
    Binding activeMqBinding()
    {
        return BindingBuilder.bind(activeMqQueue()).to(topicExchange()).with("activeMQ.#");
    }
    /**
     * 创建绑定对象，该绑定对象将队列名为rabbitMQ的队列与TopicExchange路由策略进行绑定，并指定路由规则
     * @return 绑定对象
     */
    @Bean
    Binding rabbitMqBinding()
    {
        return BindingBuilder.bind(rabbitMqQueue()).to(topicExchange()).with("rabbitMQ.#");
    }
    /**
     * 创建绑定对象，该绑定对象将队列名为mqQueue的队列与TopicExchange路由策略进行绑定，并指定路由规则
     * @return 绑定对象
     */
    @Bean
    Binding mqBinding()
    {
        return BindingBuilder.bind(mqQueue()).to(topicExchange()).with("#.mq.#");
    }
}
