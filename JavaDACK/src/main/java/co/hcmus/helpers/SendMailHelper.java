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

/**
 * @author Thanh Toan
 * 
 */
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
	 * Send mail from "username" to "recipient" with "subject", "message" and
	 * acttach "file"
	 * 
	 * @param host
	 * @param port
	 * @param userName
	 * @param password
	 * @param recipient
	 * @param subject
	 * @param message
	 * @param attachFile
	 * @throws Exception
	 */

// 	public void sendWithFile(String host, String port, final String userName,
// 			final String password, String recipient, String subject,
// 			String message, File attachFile) throws AddressException,
// 			MessagingException {
// 		// sets SMTP server properties
// 		Properties properties = new Properties();
// 		properties.put("mail.smtp.host", host);
// 		properties.put("mail.smtp.port", port);
// 		properties.put("mail.smtp.auth", "true");
// 		properties.put("mail.smtp.starttls.enable", "true");
// 		properties.put("mail.user", userName);
// 		properties.put("mail.password", password);

// 		// creates a new session with an authenticator
// //		Authenticator auth = new Authenticator() {
// //			public PasswordAuthentication getPasswordAuthentication() {
// //				return new PasswordAuthentication(userName, password);
// //			}
// //		};
// 		Session session = Session.getInstance(properties, null);

// 		// creates a new e-mail message
// 		Message msg = new MimeMessage(session);

// 		msg.setFrom(new InternetAddress(userName));
// 		InternetAddress[] toAddresses = { new InternetAddress(recipient) };
// 		msg.setRecipients(Message.RecipientType.TO, toAddresses);
// 		msg.setSubject(subject);
// 		msg.setSentDate(new Date());

// 		// creates message part
// 		MimeBodyPart messageBodyPart = new MimeBodyPart();
// 		messageBodyPart.setContent(message, "text/html; charset=\"UTF-8\"");
// 		messageBodyPart.setHeader("Content-Type",
// 				"text/html; charset=\"utf-8\"");
// 		messageBodyPart.setHeader("Content-Tranfer-Encoding",
// 				"quoted-printable");

// 		// creates multi-part
// 		Multipart multipart = new MimeMultipart();
// 		multipart.addBodyPart(messageBodyPart);

// 		// adds attachments
// 		if (attachFile != null) {
// 			MimeBodyPart attachPart = new MimeBodyPart();

// 			try {
// 				attachPart.attachFile(attachFile);
// 			} catch (IOException ex) {
// 				ex.printStackTrace();
// 			}

// 			multipart.addBodyPart(attachPart);
// 		}
// 		// sets the multi-part as e-mail's content
// 		msg.setContent(multipart);

// 		// sends the e-mail
// 		Transport.send(msg);
// 	}

	/**
	 * function send email, not include file Ginji
	 */
	public void sendMail(EmailForm email) throws Exception {
		String smtpServer = Constant.SMTP_GMAIL;
		String from = Constant.SHOP_EMAIL;
		String password = Constant.SHOP_EMAIL_PASSWORD;

		this.send(smtpServer, email.reciver, from, password, email.subject, email.body);
	}

	/**
	 * function send email, include attached file Ginji
	 */
	// public void sendMailWithAttachedFile(String to, String subject,
	// 		String message, File attachedFile) throws Exception {
	// 	String smtpServer = "smtp.gmail.com";
	// 	String from = "nvquy082013@gmail.com";
	// 	String port = "465";
	// 	String password = "nv123456789";
	// 	this.sendWithFile(smtpServer, port, from, password, to, subject,
	// 			message, attachedFile);
	// }
}
