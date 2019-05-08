package com.springboot.demo.job.config;

import com.springboot.demo.job.SendFileEmailJob;
import com.springboot.demo.job.SendSimpleEmailJob;
import com.springboot.demo.sendMail.FileEmail;
import com.springboot.demo.sendMail.SimpleEmail;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.io.File;
import java.util.Date;

@Configuration
public class QuartzConfig {
    /**
     * 获取发送简易文本邮件定时任务
     * @return 发送简易文本邮件定时任务实例
     */
    @Bean
    JobDetailFactoryBean getSimpleEmailJobDetail()
    {
        JobDetailFactoryBean simpleEmailJob=new JobDetailFactoryBean();
        simpleEmailJob.setJobClass(SendSimpleEmailJob.class);
        SimpleEmail simpleEmail=new SimpleEmail();
        simpleEmail.setFromEmail("99967706@qq.com");
        simpleEmail.setToEmail("596648433@qq.com");
        simpleEmail.setSubject("定时任务发送文本邮件测试");
        simpleEmail.setCcList("99967706@qq.com");
        simpleEmail.setContent("SpringBoot定时任务发送简单文本邮件"+new Date().toString());
        //设置参数
        JobDataMap dataMap=new JobDataMap();
        dataMap.put("simpleEmail",simpleEmail);
        simpleEmailJob.setJobDataMap(dataMap);
        simpleEmailJob.setDurability(true);
        return simpleEmailJob;
    }

    /**
     * 获取发送附件邮件定时任务
     * @return 发送附件邮件定时任务实例
     */
    @Bean
    JobDetailFactoryBean getFileEmailJobDetail()
    {
        JobDetailFactoryBean fileEmailJob=new JobDetailFactoryBean();
        fileEmailJob.setJobClass(SendFileEmailJob.class);
        FileEmail fileEmail=new FileEmail();
        fileEmail.setFromEmail("99967706@qq.com");
        fileEmail.setToEmail("596648433@qq.com");
        fileEmail.setSubject("SpringBoot定时任务发送附件邮件");
        fileEmail.setContent("SpringBoot定时任务发送包含附件邮件");
        fileEmail.setFileInfo(new File("C:\\Users\\Admin\\Desktop\\mybatis.png"));
        //设置参数
        JobDataMap dataMap=new JobDataMap();
        dataMap.put("fileEmail",fileEmail);
        fileEmailJob.setJobDataMap(dataMap);
        fileEmailJob.setDurability(true);
        return fileEmailJob;
    }

    /**
     * 简易触发器
     * @return 简易触发器实例
     */
    @Bean
    SimpleTriggerFactoryBean getSimpleTrigger()
    {
        //初始化简易触发器
        SimpleTriggerFactoryBean simpleTriggerBean=new SimpleTriggerFactoryBean();
        //为触发器绑定定时任务
        simpleTriggerBean.setJobDetail(getSimpleEmailJobDetail().getObject());
        //设置定时任务执行次数
        simpleTriggerBean.setRepeatCount(1);
        //定时任务初始化执行延迟时间
        simpleTriggerBean.setStartDelay(1000);
        //定时任务执行时间间隔
        simpleTriggerBean.setRepeatInterval(2000);
        return simpleTriggerBean;
    }

    /**
     * Crom表达式触发器
     * @return cron表达式触发器实例
     */
    @Bean
    CronTriggerFactoryBean getCronTrigger()
    {
       //初始化Cron表达式触发器
        CronTriggerFactoryBean cronTrigger=new CronTriggerFactoryBean();
        //触发器绑定定时任务
        cronTrigger.setJobDetail(getFileEmailJobDetail().getObject());
        //设置cron表达式(每天22:30自动执行定时任务)
        cronTrigger.setCronExpression("0 30 22 * * ?");
        return cronTrigger;
    }

    /**
     * 创建定时任务工厂并设置触发器
     * @return 定时任务工厂
     */
    @Bean
    SchedulerFactoryBean getSchedulerFactory()
    {
        //初始化定时任务工厂实例
        SchedulerFactoryBean schedulerFactory=new SchedulerFactoryBean();
        //获取绑定定时任务后的触发器
        SimpleTrigger simpleTrigger=getSimpleTrigger().getObject();
        CronTrigger cronTrigger=getCronTrigger().getObject();
        //为定时任务工厂设置触发器
        schedulerFactory.setTriggers(simpleTrigger,cronTrigger);
        //返回定时任务工厂
        return schedulerFactory;
    }

}
