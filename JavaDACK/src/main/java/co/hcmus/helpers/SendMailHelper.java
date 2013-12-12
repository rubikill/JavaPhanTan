package co.hcmus.helpers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.hcmus.models.EmailForm;
import co.hcmus.util.Constant;

import org.springframework.stereotype.Service;

/**
 * @author Thanh Toan
 * 
 */

@Service("sendMailHelper")
public class SendMailHelper {

	public SendMailHelper(){

	}
	
	/**
	 * Send mail from "from" to "to" with "subject" and "body"
	 * 
	 * @param smtpServer
	 * @param to
	 * @param from
	 * @param password
	 * @param subject
	 * @param body
	 * @throws Exception
	 */
	public void send(String smtpServer, String to, final String from,
		final String password, String subject, String body)
	throws Exception {
		Properties props = new Properties();
		props.put("mail.smtp.host", Constant.SMTP_GMAIL);
		props.put("mail.smtp.socketFactory.port", Constant.SMTP_GMAIL_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", Constant.SMTP_GMAIL_PORT);

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			});
		try {
			Transport transport = session.getTransport("smtp");
			transport.connect(smtpServer, from, password);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);

			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * function send email, not include file Ginji
	 */
	public void sendMail(EmailForm email) throws Exception {
		String smtpServer = Constant.SMTP_GMAIL;
		String from = Constant.SHOP_EMAIL;
		String password = Constant.SHOP_EMAIL_PASSWORD;

		this.send(smtpServer, email.reciver, from, password, email.subject, email.body);
	}
}
