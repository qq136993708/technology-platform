package com.pcitc.util.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * <p>Title: 系统邮件</p>
 * <p>Description: 发送邮件校验</p>
 * <p>Copyright: Copyright (c) 2014 YOUS</p>
 * <p>Company: 石化盈科</p>
 * <p>last modified: 2014-01-20 王飞</p>
 * @author 王飞（13911824102@139.COM）
 * @version 1.0
 */
public class MyAuthenticator extends Authenticator{   
    String userName=null;   
    String password=null;   
        
    public MyAuthenticator(){   
    }   
    public MyAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }   
}