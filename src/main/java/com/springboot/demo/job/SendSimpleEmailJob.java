package com.springboot.demo.job;

import com.springboot.demo.sendMail.SimpleEmail;
import com.springboot.demo.sendMail.service.EmailService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 发送文本文件定时任务
 */
@Component
public class SendSimpleEmailJob extends QuartzJobBean {
    private SimpleEmail simpleEmail;
    @Autowired
    private EmailService emailService;
    public void setSimpleEmail(SimpleEmail simpleEmail) {
        this.simpleEmail = simpleEmail;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        emailService.sendSimpleMail(this.simpleEmail);
    }
}
