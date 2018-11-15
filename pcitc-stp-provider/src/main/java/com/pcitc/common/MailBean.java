package com.pcitc.common;

import java.io.Serializable;

import javax.mail.internet.MimeMultipart;

public class MailBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6530231241006522033L;
	
	private String mailTo;
	private String mailTitle;
	private String mailContent;
	private MimeMultipart multipart;
	
	public MailBean() {
		super();
	}
	public MailBean(String mailTo, String mailTitle, String mailContent) {
		super();
		this.mailTo = mailTo;
		this.mailTitle = mailTitle;
		this.mailContent = mailContent;
	}
	public MailBean(String mailTo, String mailTitle, String mailContent, MimeMultipart multipart) {
		super();
		this.mailTo = mailTo;
		this.mailTitle = mailTitle;
		this.mailContent = mailContent;
		this.multipart = multipart;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getMailTitle() {
		return mailTitle;
	}
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
	public String getMailContent() {
		return mailContent;
	}
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	public MimeMultipart getMultipart() {
		return multipart;
	}
	public void setMultipart(MimeMultipart multipart) {
		this.multipart = multipart;
	}
}
