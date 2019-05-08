package com.springboot.demo.mq.rabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitDirectConfig {
    public final static String directName="amqp-direct";

    /**
     * 创建名为rabbitmq-queue的队列并返回
     * @return 队列
     */
    @Bean
   public Queue queue()
    {
        return new Queue("rabbitmq-queue");
    }

    /**
     * 创建directExchange(参数分别为directName、重启是否依然有效、长期未使用是否自动删除)
     * @return DirectExchange
     */
    @Bean
    DirectExchange directExchange()
    {
        return new DirectExchange(directName,true,false);
    }

    /**
     * 创建队列及交换策略绑定对象并实现绑定(路由key为队列名称)
     * @return绑定对象
     */
    @Bean
    Binding bindingDirectAndExchange()
    {
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}
