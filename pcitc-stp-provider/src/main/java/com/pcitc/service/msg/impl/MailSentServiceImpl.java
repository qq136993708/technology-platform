package com.pcitc.service.msg.impl;

import java.io.File;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import com.pcitc.util.mail.MailSender;
import com.pcitc.util.mail.MailSenderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.pcitc.common.MailBean;
import com.pcitc.service.msg.MailSentService;

@Service("mailSentService")
public class MailSentServiceImpl implements MailSentService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

//        mailInfo = new MailSenderInfo();
//        mailInfo.setMailServerHost("smtp.163.com");
//        mailInfo.setMailServerPort("25");
//        mailInfo.setValidate(true);
//        mailInfo.setUserName("mlc19860417@163.com");
//        mailInfo.setPassword("mlc11111111");
//        mailInfo.setFromAddress("mlc19860417@163.com");
//        mailInfo.setSenderDisplay("石化盈科信息技术有限责任公司");

    @Value("${spring.mail.host}")
    private String mailSenderHost;
    @Value("${spring.mail.port}")
    private String mailSenderPort;
    @Value("${spring.mail.validate}")
    private Boolean Validate;
    @Value("${spring.mail.username}")
    private String userName;
    @Value("${spring.mail.password}")
    private String password;
    @Value("${spring.mail.from}")
    private String fromAddress;
    @Value("${spring.mail.display}")
    private String senderDisplay;

    /**
     * 带附件的
     *
     * @param mailbean
     * @return
     */
    @Override
    public Integer sentAppendFileMail(MailBean mailbean) {

        try {

            MimeMessage mimeMessge = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessge, true);
            mimeMessageHelper.setTo(mailbean.getMailTo());
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(mailbean.getMailTitle());
            mimeMessageHelper.setText(mailbean.getMailContent(), true);

            File file = new File("D:/img_attr.jpg");
            mimeMessageHelper.addAttachment(MimeUtility.encodeWord(file.getName()), file);

            mailSender.send(mimeMessge);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return null;
    }

    @Override
    public boolean sendMail(MailSenderInfo mailSenderInfo) {
        boolean b = false;
        try {
            mailSenderInfo.setFromAddress(fromAddress);
            mailSenderInfo.setMailServerHost(mailSenderHost);
            mailSenderInfo.setPassword(password);
            mailSenderInfo.setUserName(userName);
            mailSenderInfo.setMailServerPort(mailSenderPort);
            mailSenderInfo.setSenderDisplay(senderDisplay);
            mailSenderInfo.setValidate(Validate);
            b = MailSender.sendMail(mailSenderInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return b;
        }
    }

    @Override
    public Integer sentMail(MailBean mailbean) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(mailbean.getMailTo());
            message.setSubject(mailbean.getMailTitle());
            message.setText(mailbean.getMailContent());
            mailSender.send(message);

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
