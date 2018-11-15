package com.pcitc.service.msg.impl;

import java.io.File;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

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
	
	/**
	 * 带附件的
	 * @param mailbean
	 * @return
	 */
	@Override
	public Integer sentAppendFileMail(MailBean mailbean) 
	{
		   
		try
		{
			
		   MimeMessage mimeMessge = mailSender.createMimeMessage();
		   MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessge,true);
		   mimeMessageHelper.setTo(mailbean.getMailTo());
		   mimeMessageHelper.setFrom(from);
		   mimeMessageHelper.setSubject(mailbean.getMailTitle());
		   mimeMessageHelper.setText(mailbean.getMailContent(),true);   
		   
		   File file = new File("D:/img_attr.jpg");
		   mimeMessageHelper.addAttachment(MimeUtility.encodeWord(file.getName()),file);     
		   
		   mailSender.send(mimeMessge);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return null;
	}
	
	
	@Override
	public Integer sentMail(MailBean mailbean) 
	{
		try
		{
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(from);
	        message.setTo(mailbean.getMailTo());
	        message.setSubject(mailbean.getMailTitle());
	        message.setText(mailbean.getMailContent());
	        mailSender.send(message);
	        
	        return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
    
}
