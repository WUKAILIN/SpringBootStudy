package com.springboot.demo.sendMail.service;

import com.springboot.demo.sendMail.FileEmail;
import com.springboot.demo.sendMail.ImageEmail;
import com.springboot.demo.sendMail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {
    @Autowired
    JavaMailSender mailSender;

    /**
     * 发送简单邮件
     * @param simpleEmail：简单邮件实体
     */
    public void sendSimpleMail(SimpleEmail simpleEmail)
    {
        //简单邮件消息
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(simpleEmail.getFromEmail());
        simpleMailMessage.setTo(simpleEmail.getToEmail());

            simpleMailMessage.setCc(simpleEmail.getCcList());

        simpleMailMessage.setSubject(simpleEmail.getSubject());
        simpleMailMessage.setText(simpleEmail.getContent());
        mailSender.send(simpleMailMessage);
    }

    /**
     * 发送带图片邮件
     * @param imageEmail:图片邮件实体
     */
    public void sendImageMail(ImageEmail imageEmail)
    {
        if(imageEmail.getSrcPath().length!=imageEmail.getResIds().length)
        {
            System.out.println("图片资源与resIds元素数量不一致，发送失败");
        }
        try {
            MimeMessage mimeMessage=mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(imageEmail.getFromEmail());
            mimeMessageHelper.setTo(imageEmail.getToEmail());
            mimeMessageHelper.setSubject(imageEmail.getSubject());
            mimeMessageHelper.setText(imageEmail.getContent(),true);
            for(int i=0;i<imageEmail.getSrcPath().length;i++)
            {
                //根据图片路径构建静态资源
                FileSystemResource systemResource=new FileSystemResource(new File(imageEmail.getSrcPath()[i]));
                //将静态资源加入邮件对象
                mimeMessageHelper.addInline(imageEmail.getResIds()[i],systemResource);
            }
            mailSender.send(mimeMessage);
        }catch (MessagingException ex)
        {
            System.out.println("发送失败");
        }
    }

    /**
     * 发送附件邮件
     * @param fileEmail:附件邮件
     */
    public void sendFileEmail(FileEmail fileEmail)
    {
        if(fileEmail.getFileInfo()==null)
        {
            System.out.println("未上传附件文件，发送失败");
        }
        try {
            MimeMessage fileMessage=mailSender.createMimeMessage();
            MimeMessageHelper fileHelper=new MimeMessageHelper(fileMessage,true);
            fileHelper.setFrom(fileEmail.getFromEmail());
            fileHelper.setTo(fileEmail.getToEmail());
            fileHelper.setSubject(fileEmail.getSubject());
            fileHelper.setText(fileEmail.getContent());
            //添加附件(文件名作为附件名)
            fileHelper.addAttachment(fileEmail.getFileInfo().getName(),fileEmail.getFileInfo());
            mailSender.send(fileMessage);
        }catch (MessagingException ex)
        {
            ex.printStackTrace();
        }
    }
}
