package com.springboot.demo.mq.activemq.impl;

import com.springboot.demo.mq.activemq.ActiveMqService;
import com.springboot.demo.mq.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class ActiveMqServiceImpl implements ActiveMqService {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Override
    public void sendUserMessage(UserInfo userInfo) {
        jmsMessagingTemplate.convertAndSend(this.queue,userInfo);
    }
    @JmsListener(destination = "activeMqTest")
    @Override
    public void receiveUserMessage(UserInfo userInfo) {
       System.out.println("接收到的用户信息------"+userInfo.getUserId()+",--------发送时间:"+userInfo.getSendDate());
    }
}
