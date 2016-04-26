package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * <pre>
 * 已完成有認證和沒認證的發smtp的method
 * 需完成html發送本文、附件、ssl(再確認要不要實作)
 * 參考下列網扯設定參數
 * https://javamail.java.net/nonav/docs/api/com/sun/mail/smtp/package-summary.html
 * </pre>
 * @author ai
 */
public class Javax的mail {

	public static void main(String[] args) {
		Javax的mail m = new Javax的mail();
		// m.$001單純的smtp轉導();
		m.$101登入的smtp轉導();
		System.out.println("done");
	}

	public void $001單純的smtp轉導() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "127.0.0.1");
		props.put("mail.transport.protocol", "smtp");
		Session session = Session.getDefaultInstance(props, null);
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ansx86a@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," + "\n\n No spam to my email, please!");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void $101登入的smtp轉導() {
		final String username = "sa@aaa.bbb";
		final String password = "sa";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "127.0.0.1");
		props.put("mail.smtp.port", "587");
		props.put("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ansx86a@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," + "\n\n No spam to my email, please!");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
