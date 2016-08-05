package com.begin.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class SimpleEmailClient {

	/**
	 * 发送简单邮件
	 * 
	 * @param email
	 *            目标Email地址
	 * @param title
	 *            邮件标题
	 * @param context
	 *            邮件内容
	 * @param isHTML
	 *            如果为true则邮件内容以HTML文本格式发送否则以普通文本格式发送
	 * @param encoding
	 *            邮件内容编码
	 * @return 发送成功返回true否则返回false
	 */
	public void sendSimpleEmail(String emails, String title, String context) throws Exception {

		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");// 必须 普通客户端
		props.setProperty("mail.transport.protocol", "smtp");// 必须选择协议
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);// 设置debug模式 在控制台看到交互信息
		Message msg = new MimeMessage(session); // 建立一个要发送的信息
		msg.setText(context);// 设置简单的发送内容
		msg.setFrom(new InternetAddress("419179186@qq.com"));// 发件人邮箱号
		msg.setSubject(title);
		Transport transport = session.getTransport();// 发送信息的工具
		// transport.connect("smtp.qq.com", 465, "419179186@qq.com",
		// "huaAiZJ1314");// 发件人邮箱号// 和密码
		transport.connect("smtp.qq.com", 465, "419179186@qq.com",
				"noeqkeezlaplcbdj");// 发件人邮箱号
		transport.sendMessage(msg, new Address[] { new InternetAddress(
				emails) });// 对方的地址
		transport.close();

	}

}
