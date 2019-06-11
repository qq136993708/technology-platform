package com.pcitc.service.msg;

import com.pcitc.common.MailBean;
import com.pcitc.util.mail.MailSenderInfo;

/**
 * 邮件发送
 * @author fb
 *
 */
public interface MailSentService 
{
	/**
	 *  发送普通邮件
	 * @param mailbean
	 * @return
	 */
	Integer sentMail(MailBean mailbean);
	/**
	 * 发送带附件邮件
	 * @param mailbean
	 * @return
	 */
	Integer sentAppendFileMail(MailBean mailbean);

	boolean sendMail(MailSenderInfo mailSenderInfo);

	boolean sendMailFileInputStream(MailSenderInfo mailSenderInfo);

}
