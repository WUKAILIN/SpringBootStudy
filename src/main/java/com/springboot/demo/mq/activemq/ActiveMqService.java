package com.springboot.demo.mq.activemq;

import com.springboot.demo.mq.pojo.UserInfo;

/**
 * 消息服务接口
 */
public interface ActiveMqService {
    /**
     * 发送用户消息
     * @param userInfo
     */
    public void sendUserMessage(UserInfo userInfo);

    /**
     * 接收用户消息
     * @param userInfo
     */
    public void receiveUserMessage(UserInfo userInfo);
}

