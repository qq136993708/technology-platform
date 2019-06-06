package com.pcitc.util.mail;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.*;
import java.util.Date;
import java.util.Properties;
import java.io.ByteArrayInputStream;

/**
 * <p>Title: 系统邮件</p>
 * <p>Description: 发送邮件</p>
 * <p>Copyright: Copyright (c) 2014 YOUS</p>
 * <p>Company: 石化盈科</p>
 * <p>last modified: 2014-01-20 王飞</p>
 *
 * @author 王飞（13911824102@139.COM）
 * @version 1.0
 */
public class MailSender {

    private static MailSenderInfo mailInfo;

    static {
        //初始化邮箱服务配置参数
//        mailInfo = new MailSenderInfo();
//        mailInfo.setMailServerHost(SysParam.getParamByNm("邮件服务器地址"));
//        mailInfo.setMailServerPort(SysParam.getParamByNm("邮件服务器端口"));
//        mailInfo.setValidate(true);
//        mailInfo.setUserName(SysParam.getParamByNm("邮件服务器用户名"));
//        mailInfo.setPassword(SysParam.getParamByNm("邮件服务器密码"));
//        mailInfo.setFromAddress(SysParam.getParamByNm("邮件发送邮箱"));
//        mailInfo.setSenderDisplay(SysParam.getParamByNm("发送邮箱显示名称"));
//        #spring.mail.host=smtp.exmail.qq.com
//#spring.mail.username=3762835@qq.com
//#spring.mail.password=vgdqolrzbhgc
//#spring.mail.properties.mail.smtp.auth=true
//#spring.mail.properties.mail.smtp.starttls.enable=true
//#spring.mail.properties.mail.smtp.stattls.required=true

        mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("mlc19860417@163.com");
        mailInfo.setPassword("mlc5201314");
        mailInfo.setFromAddress("mlc19860417@163.com");
        mailInfo.setSenderDisplay("石化盈科信息技术有限责任公司");
    }

    /**
     * 验证邮箱服务状态
     */
    public static boolean checkMailstate() {
        boolean retVal = false;
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        retVal = (sendMailSession != null);
        return retVal;
    }

    /**
     * 以文本格式发送邮件
     *
     * @param Info 邮件配置对象
     */
    public static boolean sendMail(MailSenderInfo Info) {
        boolean retVal = false;
        if (Info.getToAddress() == null || Info.getToAddress().length == 0) return retVal;
        if (Info.getSubject() == null || Info.getSubject().length() == 0) return retVal;
        Info = dealParam(Info);

        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = Info.getProperties();
        if (Info.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(Info.getUserName(), Info.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
//            mailMessage.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
            // 创建邮件发送者地址
            Address from = new InternetAddress(Info.getFromAddress(), Info.getSenderDisplay());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address[] to = new InternetAddress[Info.getToAddress().length];
            for (int i = 0; i < Info.getToAddress().length; i++) {
                to[i] = new InternetAddress(Info.getToAddress()[i]);
            }
            mailMessage.setRecipients(Message.RecipientType.TO, to);
            // 创建邮件的抄送人地址，并设置到邮件消息中
            if (Info.getCcAddress() != null && Info.getCcAddress().length > 0) {
                Address[] cc = new InternetAddress[Info.getCcAddress().length];
                for (int i = 0; i < Info.getCcAddress().length; i++) {
                    cc[i] = new InternetAddress(Info.getCcAddress()[i]);
                }
                mailMessage.setRecipients(Message.RecipientType.CC, cc);
            }
            // 创建邮件密送人地址，并设置到邮件消息中
            if (Info.getBccAddress() != null && Info.getBccAddress().length > 0) {
                Address[] bcc = new InternetAddress[Info.getBccAddress().length];
                for (int i = 0; i < Info.getBccAddress().length; i++) {
                    bcc[i] = new InternetAddress(Info.getBccAddress()[i]);
                }
                mailMessage.setRecipients(Message.RecipientType.BCC, bcc);
            }

            // 设置邮件消息的主题
            mailMessage.setSubject(Info.getSubject());

            // 设置邮箱正文
            Multipart mp = new MimeMultipart();
            MimeBodyPart mbp = new MimeBodyPart();
            if (Info.isHtml()) {
                mbp.setContent(Info.getContent(), "text/plain;charset=UTF-8");
            } else {
                mbp.setContent(Info.getContent(), "text/html;charset=UTF-8");
            }
            mp.addBodyPart(mbp);

            // 设置邮件附件
            if (Info.getAttachFileNames() != null && Info.getAttachFileNames().length > 0) {
                for (int i = 0; i < Info.getAttachFileNames().length; i++) {
                    mbp = new MimeBodyPart();
                    String fileName = Info.getAttachFileNames()[i];
                    FileDataSource fds = new FileDataSource(fileName);
                    mbp.setDataHandler(new DataHandler(fds));
                    mbp.setFileName(MimeUtility.encodeText(fds.getName()));
                    mp.addBodyPart(mbp);
                }
            }
            // 设置邮件整体内容
            mailMessage.setContent(mp);
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            mailMessage.saveChanges();

            // 发送邮件
            Transport trans = sendMailSession.getTransport("smtp");
            trans.connect(Info.getMailServerHost(), Info.getUserName(), Info.getPassword());
            trans.sendMessage(mailMessage, mailMessage.getAllRecipients());
            retVal = true;
            return retVal;
        } catch (Exception ex) {
            ex.printStackTrace();
            return retVal;
        }
    }

    public static boolean sendMailFileInputStream(MailSenderInfo Info) {
        boolean retVal = false;
        if (Info.getToAddress() == null || Info.getToAddress().length == 0) return retVal;
        if (Info.getSubject() == null || Info.getSubject().length() == 0) return retVal;
        Info = dealParam(Info);

        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = Info.getProperties();
        if (Info.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(Info.getUserName(), Info.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
//            mailMessage.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
            // 创建邮件发送者地址
            Address from = new InternetAddress(Info.getFromAddress(), Info.getSenderDisplay());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address[] to = new InternetAddress[Info.getToAddress().length];
            for (int i = 0; i < Info.getToAddress().length; i++) {
                to[i] = new InternetAddress(Info.getToAddress()[i]);
            }
            mailMessage.setRecipients(Message.RecipientType.TO, to);
            // 创建邮件的抄送人地址，并设置到邮件消息中
            if (Info.getCcAddress() != null && Info.getCcAddress().length > 0) {
                Address[] cc = new InternetAddress[Info.getCcAddress().length];
                for (int i = 0; i < Info.getCcAddress().length; i++) {
                    cc[i] = new InternetAddress(Info.getCcAddress()[i]);
                }
                mailMessage.setRecipients(Message.RecipientType.CC, cc);
            }
            // 创建邮件密送人地址，并设置到邮件消息中
            if (Info.getBccAddress() != null && Info.getBccAddress().length > 0) {
                Address[] bcc = new InternetAddress[Info.getBccAddress().length];
                for (int i = 0; i < Info.getBccAddress().length; i++) {
                    bcc[i] = new InternetAddress(Info.getBccAddress()[i]);
                }
                mailMessage.setRecipients(Message.RecipientType.BCC, bcc);
            }

            // 设置邮件消息的主题
            mailMessage.setSubject(Info.getSubject());

            // 设置邮箱正文
            Multipart mp = new MimeMultipart();
            MimeBodyPart mbp = new MimeBodyPart();
            if (Info.isHtml()) {
                mbp.setContent(Info.getContent(), "text/plain;charset=UTF-8");
            } else {
                mbp.setContent(Info.getContent(), "text/html;charset=UTF-8");
            }
            mp.addBodyPart(mbp);

            // 设置邮件附件
            if (Info.getAttachFileUrls() != null && Info.getAttachFileUrls().length > 0) {

                for (int i = 0; i < Info.getAttachFileUrls().length; i++) {
                    mbp = new MimeBodyPart();
                    String fileUrl = Info.getAttachFileUrls()[i];
                    InputStream inputStream =OSSUtil.getOssFileIS(fileUrl.split(OSSUtil.OSSPATH+"/"+OSSUtil.BUCKET+"/")[1]);
                    DataSource source = new ByteArrayDataSource(inputStream, "application/msexcel");
                    mbp.setDataHandler(new DataHandler(source));
                    mbp.setFileName(MimeUtility.encodeText(Info.getAttachFileNames()[i]));
                    mp.addBodyPart(mbp);
                }
            }
            // 设置邮件整体内容
            mailMessage.setContent(mp);
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            mailMessage.saveChanges();

            // 发送邮件
            Transport trans = sendMailSession.getTransport("smtp");
            trans.connect(Info.getMailServerHost(), Info.getUserName(), Info.getPassword());
            trans.sendMessage(mailMessage, mailMessage.getAllRecipients());
            retVal = true;
            return retVal;
        } catch (Exception ex) {
            ex.printStackTrace();
            return retVal;
        }
    }

    private static MailSenderInfo dealParam(MailSenderInfo Info) {
        //处理用户传入参数
        MailSenderInfo retVal = new MailSenderInfo();
        retVal.setToAddress(Info.getToAddress());
        retVal.setCcAddress(Info.getCcAddress());
        retVal.setBccAddress(Info.getBccAddress());
        retVal.setSubject(Info.getSubject());
        retVal.setContent(Info.getContent() == null ? "" : Info.getContent());
        retVal.setUserName(Info.getUserName() == null ? mailInfo.getUserName() : Info.getUserName());
        retVal.setPassword(Info.getPassword() == null ? mailInfo.getPassword() : Info.getPassword());
        retVal.setMailServerHost(Info.getMailServerHost() == null ? mailInfo.getMailServerHost() : Info.getMailServerHost());
        retVal.setMailServerPort(Info.getMailServerPort() == null ? mailInfo.getMailServerPort() : Info.getMailServerPort());
        retVal.setFromAddress(Info.getFromAddress() == null ? mailInfo.getFromAddress() : Info.getFromAddress());
        retVal.setSenderDisplay(Info.getSenderDisplay() == null ? mailInfo.getSenderDisplay() : Info.getSenderDisplay());
        retVal.setAttachFileNames(Info.getAttachFileNames());
        retVal.setAttachFileUrls(Info.getAttachFileUrls());
        retVal.setValidate(Info.isValidate());
        return retVal;
    }

    public static void main(String[] args) {
        MailSenderInfo info = new MailSenderInfo();
        String[] to = new String[]{"635447170@qq.com"};
        //String[] cc = new String[]{"greetwangfei@126.com"};
        //String[] bcc = new String[]{"guohui.l@pcitc.com"};
        //String[] attach = new String[]{"C:\\Users\\WangFei\\Desktop\\pcitc.jar"};
        String subject = "测试邮件标题（2014-01-23）";
        String content = "<p>尊敬的${name}您好:</p>\n" +
                "\n" +
                "<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 中国石化特邀您于${date}对${project}进行评审,请准时参加,联系电话:${mobile}</p>\n";
        info.setToAddress(to);//收件人

        info.setAttachFileNames(new String[]{"我勒个去.jpg"});
        info.setAttachFileUrls(new String[]{"http://oss01-cn-beijing-sinopec-d01-a.yun-inc.sinopec.com/stp-vpc1-sctepl/files/uploadPath/4f4234fa5a774585a460e8af3e436003/20190604104711655_file_16b20622628_bbb76076.jpg"});
        //info.setCcAddress(cc);//抄送人
        //info.setBccAddress(bcc);//密送人
        System.out.println(info.getAttachFileUrls()[0]);
        info.setSubject(subject);//标题
        content=content.replace("${name}","张三").replace("${date}","2018-08-08");
        content=content.replace("${project}","项目");
        content=content.replace("${mobile}","13501043033");
        info.setContent(content);//正文

        System.out.println(content);
        //info.setAttachFileNames(attach);//邮件附件
        info.setIsHtml(true);//是否为html内容
        MailSender.sendMailFileInputStream(info);
    }
}   