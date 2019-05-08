package com.springboot.demo.sendMail;

import java.io.File;

public class FileEmail {
    private String fromEmail;//发送邮箱地址
    private String toEmail;//接收邮箱地址
    private String subject;//邮件主题
    private String content;//邮件内容
    private File fileInfo;//附件文件

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public File getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(File fileInfo) {
        this.fileInfo = fileInfo;
    }
}
