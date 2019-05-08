package com.springboot.demo;

import com.springboot.demo.mq.activemq.ActiveMqService;
import com.springboot.demo.mq.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ActiveMQTest {
    @Autowired
    private ActiveMqService activeMqServiceImpl;
    @Test
    public void testMQ()
    {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(101);
        userInfo.setSendDate(new Date());
        activeMqServiceImpl.sendUserMessage(userInfo);
    }
}
