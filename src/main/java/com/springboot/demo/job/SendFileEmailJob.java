package com.springboot.demo.job;

import com.springboot.demo.sendMail.FileEmail;
import com.springboot.demo.sendMail.service.EmailService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * 发送附件邮件定时任务
 */
@Component
public class SendFileEmailJob extends QuartzJobBean {
    private FileEmail fileEmail;
    @Autowired
    private EmailService emailService;

    public void setFileEmail(FileEmail fileEmail) {
        this.fileEmail = fileEmail;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        emailService.sendFileEmail(fileEmail);
    }
}
