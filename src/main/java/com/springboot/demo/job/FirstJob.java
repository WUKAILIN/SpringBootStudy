package com.springboot.demo.job;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FirstJob {
    public void firstJobTest()
    {
        System.out.println("firstJob-------"+new Date());
    }
}
