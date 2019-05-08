package com.springboot.demo.mq.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitFanoutConfig {
    public final static String fanoutExchangeName="rabbitmq-fanout";

    /**
     * 创建FanoutExchange,参数分别为fanoutExchangeName,重启是否依然有效(boolean),长期未使用是否自动删除(boolean)
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange()
    {
        return new FanoutExchange(fanoutExchangeName,true,false);
    }

    /**
     * 创建队列名为fanoutqueue-one的队列
     * @return 队列
     */
    @Bean
    Queue fanoutQueueOne()
    {
        return new Queue("fanoutqueue-one");
    }

    /**
     * 创建队列名为fanoutqueue-two的队列
     * @return 队列
     */
    @Bean
    Queue fanoutQueueTwo()
    {
        return new Queue("fanoutqueue-two");
    }

    /**
     * 创建绑定对象并将队列和转发策略进行绑定关联
     * @return 绑定对象
     */
    @Bean
    Binding bindingFanoutOne()
    {
        return BindingBuilder.bind(fanoutQueueOne()).to(fanoutExchange());
    }
    /**
     * 创建绑定对象并将队列和转发策略进行绑定关联
     * @return 绑定对象
     */
    @Bean
    Binding bindingFanoutTwo()
    {
        return BindingBuilder.bind(fanoutQueueTwo()).to(fanoutExchange());
    }
}
