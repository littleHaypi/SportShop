package com.nll.Sport.util;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MyUtil {
	//定义一些全局变量
	public String myEmail="n2911337127@163.com";
	public String smtpHost="smtp.163.com";
	public String myPwd="HHWPJTNEGDCANMZC";
	public String sendMail(String email){
		//发邮件 首先，先随机出验证码
		Random r=new Random();
		String code="";
		for (int i = 0; i < 6; i++) {
			code+=r.nextInt(10);
		}
		//存一下验证码 方便用户注册的时候来验证
		//Data.code=code;
		
		System.out.print(code);
		try {
			//开始发邮件
			Properties props=new Properties();//开始创建配置参数
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtp.host", smtpHost);
			props.setProperty("mail.smtp.auth", "true");
			//根据配置来得到会话对象
			Session session=Session.getInstance(props);
			//通过会话对象来得到邮箱对象
			MimeMessage message=new MimeMessage(session);
			//设置一下发件人
			message.setFrom(new InternetAddress(myEmail,"小太阳运动商城","UTF-8"));
			//设置一下收件人
			message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(email,"用户","UTF-8"));
			//设置邮箱主题
			message.setSubject("欢迎使用小太阳运动商城","UTF-8");
			//设置内容
			message.setContent("尊敬的用户 你好 您的注册码为"+code,"text/html;charset=UTF-8");
			//设置发件时间
			message.setSentDate(new Date());
			message.saveChanges();
			//开始发送邮
			Transport transport=session.getTransport();
			transport.connect(myEmail,myPwd);
			transport.sendMessage(message, message.getAllRecipients());
			//发送成功 关闭连接
			transport.close();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
		
	}
}
