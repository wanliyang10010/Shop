package cn.xaut.shop.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {

	private SendMail config = null;

	public MailSender() {
		config = MailBoxUtil.getConfig();
	}

	// private String mailServerHost = "";
	// private String fromAddress = "";
	// private String userName = "";
	// private String password = "";
	//

	//
	// public void setMailServerHost(String mailServerHost) {
	// this.mailServerHost = mailServerHost;
	// }
	//
	// public void setUserName(String userName) {
	// this.userName = userName;
	// }
	//
	// public void setPassword(String password) {
	// this.password = password;
	// }
	//
	// public void setFromAddress(String fromAddress) {
	// this.fromAddress = fromAddress;
	// }

	public boolean sendTextMail(SendMail mailInfo) {
		// 判断是否需要身份认证
		Authentication authenticator = null;
		// mailInfo.setMailServerHost(mailServerHost); // 这里填发送者的邮箱服务器，我以qq举个例子
		// mailInfo.setMailServerPort("25");
		// mailInfo.setValidate(true);
		// mailInfo.setUserName(userName); // 发送者的邮箱名字
		// mailInfo.setPassword(password);// 发送者邮箱密码
		// mailInfo.setFromAddress(fromAddress); // 发送者邮箱名字

		mailInfo.setMailServerHost(config.getMailServerHost()); // 这里填发送者的邮箱服务器，我以qq举个例子
		mailInfo.setMailServerPort(config.getMailServerPort());
		mailInfo.setValidate(config.isValidate());
		mailInfo.setUserName(config.getUserName()); // 发送者的邮箱名字
		mailInfo.setPassword(config.getPassword());// 发送者邮箱密码
		mailInfo.setFromAddress(config.getFromAddress()); // 发送者邮箱名字

		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器
			authenticator = new Authentication(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session
				.getDefaultInstance(pro, authenticator);
		try {
			Message mailMessage = new MimeMessage(sendMailSession);
			Address from = new InternetAddress(mailInfo.getFromAddress());
			mailMessage.setFrom(from);
			Address to = new InternetAddress(mailInfo.getToAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			mailMessage.setSubject(mailInfo.getSubject());
			mailMessage.setSentDate(new Date());
			String mailContent = mailInfo.getContent();
			mailMessage.setText(mailContent);
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 以HTML格式发送邮件
	 */
	public boolean sendHtmlMail(SendMail mailInfo) {
		// 判断是否需要身份认证
		Authentication authenticator = null;
		// mailInfo.setMailServerHost(mailServerHost); // 这里填发送者的邮箱服务器，我以qq举个例子
		// mailInfo.setMailServerPort("25");
		// mailInfo.setValidate(true);
		// mailInfo.setUserName(userName); // 发送者的邮箱名字
		// mailInfo.setPassword(password);// 发送者邮箱密码
		// mailInfo.setFromAddress(fromAddress); // 发送者邮箱名字

		mailInfo.setMailServerHost(config.getMailServerHost()); // 这里填发送者的邮箱服务器，我以qq举个例子
		mailInfo.setMailServerPort(config.getMailServerPort());
		mailInfo.setValidate(config.isValidate());
		mailInfo.setUserName(config.getUserName()); // 发送者的邮箱名字
		mailInfo.setPassword(config.getPassword());// 发送者邮箱密码
		mailInfo.setFromAddress(config.getFromAddress()); // 发送者邮箱名字

		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			authenticator = new Authentication(mailInfo.getUserName(),
					mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session
				.getDefaultInstance(pro, authenticator);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			Address from = new InternetAddress(mailInfo.getFromAddress());
			mailMessage.setFrom(from);
			Address to = new InternetAddress(mailInfo.getToAddress());
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			mailMessage.setSubject(mailInfo.getSubject());
			mailMessage.setSentDate(new Date());
			Multipart mainPart = new MimeMultipart();
			BodyPart html = new MimeBodyPart();
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}