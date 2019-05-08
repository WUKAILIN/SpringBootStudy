package com.springboot.demo;

import com.springboot.demo.sendMail.FileEmail;
import com.springboot.demo.sendMail.ImageEmail;
import com.springboot.demo.sendMail.SimpleEmail;
import com.springboot.demo.sendMail.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SendMailTest {
    @Autowired
    private EmailService emailService;
    @Test
    public void sendSimpleEmail()
    {
        SimpleEmail simpleEmail=new SimpleEmail();
        simpleEmail.setFromEmail("99967706@qq.com");
        simpleEmail.setToEmail("596648433@qq.com");
        simpleEmail.setSubject("文本邮件测试");
        simpleEmail.setCcList("99967706@qq.com");
        simpleEmail.setContent("SpringBoot发送简单文本邮件"+new Date().toString());
        emailService.sendSimpleMail(simpleEmail);
    }
    @Test
    public void sendImageEmail()
    {
        String imgId="mybatis";
        ImageEmail imageEmail=new ImageEmail();
        imageEmail.setToEmail("596648433@qq.com");
        imageEmail.setFromEmail("99967706@qq.com");
        imageEmail.setSubject("图片邮件测试");
        String content="<html><body>" +
                "SpringBoot发送图片邮件测试<img src=\\'cid:\" + imgId + \"\\'>" +
                "</body></html>";
        imageEmail.setContent(content);
        String[] imageUrl=new String[]{"C:\\Users\\Admin\\Desktop\\mybatis.png"};
       // String[] resIds=new String[]{"mybatis","springboot","rocketmq"};
        String[] resIds=new String[]{imgId};
        imageEmail.setSrcPath(imageUrl);
        imageEmail.setResIds(resIds);
        emailService.sendImageMail(imageEmail);
    }
    @Test
    public void sendFileEmail()
    {
        FileEmail fileEmail=new FileEmail();
        fileEmail.setFromEmail("99967706@qq.com");
        fileEmail.setToEmail("596648433@qq.com");
        fileEmail.setSubject("SpringBoot发送附件邮件");
        fileEmail.setContent("SpringBoot发送包含附件邮件");
        fileEmail.setFileInfo(new File("C:\\Users\\Admin\\Desktop\\mybatis.png"));
        emailService.sendFileEmail(fileEmail);
    }
}
