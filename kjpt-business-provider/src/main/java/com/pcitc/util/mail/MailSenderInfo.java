package com.pcitc.util.mail;

import java.util.Properties;

/**
 * <p>Title: 系统邮件</p>
 * <p>Description: 发送邮件的各项参数</p>
 * <p>Copyright: Copyright (c) 2014 YOUS</p>
 * <p>Company: 石化盈科</p>
 * <p>last modified: 2014-01-20 王飞</p>
 *
 * @author 王飞（13911824102@139.COM）
 * @version 1.0
 */

public class MailSenderInfo {
    // 发送邮件的服务器的IP    
    private String mailServerHost;
    // 发送邮件的服务器的端口
    private String mailServerPort = "25";
    // 邮件发送者的地址    
    private String fromAddress;
    // 邮件发送邮箱默认显示名称
    private String senderDisplay;
    // 登陆邮件发送服务器的用户名
    private String userName;
    // 登陆邮件发送服务器的密码
    private String password;
    // 是否需要身份验证    
    private boolean validate = true;
    // 邮件接收者的地址    
    private String[] toAddress;
    // 邮件抄送者的地址
    private String[] ccAddress;
    // 邮件密送人的地址
    private String[] bccAddress;
    // 邮件主题    
    private String subject;
    // 邮件的文本内容    
    private String content;
    // 邮件附件的文件名    
    private String[] attachFileNames;
    // 邮件附件的文件地址
    private String[] attachFileUrls;
    // 邮件正文是否为html
    private boolean html = false;

    /**
     * 获得邮件会话属性
     */
    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        return p;
    }


    /**
     * @return 发送邮件的服务器IP
     */
    public String getMailServerHost() {
        return mailServerHost;
    }

    /**
     * @param mailServerHost 发送邮件的服务器IP
     */
    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    /**
     * @return 发送邮件的服务器端口
     */
    public String getMailServerPort() {
        return mailServerPort;
    }

    /**
     * @param mailServerPort 发送邮件的服务器端口
     */
    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    /**
     * @return 是否需要身份验证
     */
    public boolean isValidate() {
        return validate;
    }

    /**
     * @param validate 是否需要身份验证
     */
    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String[] getAttachFileUrls() {
        return attachFileUrls;
    }

    public void setAttachFileUrls(String[] attachFileUrls) {
        this.attachFileUrls = attachFileUrls;
    }

    /**
     * @return 附件文件地址列表
     */
    public String[] getAttachFileNames() {
        return attachFileNames;
    }

    /**
     * @param fileNames 附件文件列表地址
     */
    public void setAttachFileNames(String[] fileNames) {
        this.attachFileNames = fileNames;
    }

    /**
     * return 发送邮箱
     */
    public String getFromAddress() {
        return fromAddress;
    }

    /**
     * @param fromAddress 发送人邮箱
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    /**
     * @return 发送人邮箱密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password 发送人邮箱密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return 接收人邮箱地址列表
     */
    public String[] getToAddress() {
        return toAddress;
    }

    /**
     * @param toAddress 接收人邮箱地址列表
     */
    public void setToAddress(String[] toAddress) {
        this.toAddress = toAddress;
    }

    /**
     * @return 发送人邮箱用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName 发送人邮箱用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return 邮件主题
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @params subject 邮件主题
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return 邮件正文
     */
    public String getContent() {
        return content;
    }

    /**
     * @param textContent 邮件正文
     */
    public void setContent(String textContent) {
        this.content = textContent;
    }

    /**
     * 抄送人邮箱地址列表
     */
    public void setCcAddress(String[] ccAddress) {
        this.ccAddress = ccAddress;
    }

    /**
     * 抄送人邮箱地址列表
     */
    public String[] getCcAddress() {
        return ccAddress;
    }

    /**
     * @param bccAddress 密送人邮箱地址列表
     */
    public void setBccAddress(String[] bccAddress) {
        this.bccAddress = bccAddress;
    }

    /**
     * @return 密送人邮箱地址列表
     */
    public String[] getBccAddress() {
        return bccAddress;
    }

    /**
     * @param senderDisplay 发送邮箱默认显示名称
     */
    public void setSenderDisplay(String senderDisplay) {
        this.senderDisplay = senderDisplay;
    }

    /**
     * @return 发送邮箱默认显示名称
     */
    public String getSenderDisplay() {
        return senderDisplay;
    }

    /**
     * @param ishtml 是否是html内容
     */
    public void setIsHtml(boolean ishtml) {
        this.html = ishtml;
    }

    /**
     * @return 是否是HTML内容
     */
    public boolean isHtml() {
        return html;
    }
}   