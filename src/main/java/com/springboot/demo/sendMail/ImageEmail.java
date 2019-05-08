package com.springboot.demo.sendMail;

public class ImageEmail {
    private String fromEmail;//发送邮件地址
    private String toEmail;//接收邮件地址
    private String subject;//邮件主题
    private String content;//邮件内容
    private String[] srcPath;//图片资源路径绝对地址数组
    private String[] resIds;//资源Id数组,在image元素中通过cid:id显示(id与数组元素内容一致)

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

    public String[] getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String[] srcPath) {
        this.srcPath = srcPath;
    }

    public String[] getResIds() {
        return resIds;
    }

    public void setResIds(String[] resIds) {
        this.resIds = resIds;
    }
}
