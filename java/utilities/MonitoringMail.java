package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MonitoringMail {

	public static void sendMail(String from, String[] to, String subject, String attachmentPath, String attachmentPath1,String attachmentPath2,String attachmentName,String attachmentName1,String attachmentName2)
			throws MessagingException, AddressException, IOException {
		boolean debug = false;
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.host", "reamailrelay.corp.regn.net");

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);

		session.setDebug(debug);

		try {

			Transport bus = session.getTransport("smtp");
			bus.connect();
			Message message = new MimeMessage(session);

			// X-Priority values are generally numbers like 1 (for highest priority), 3
			// (normal) and 5 (lowest).

			message.addHeader("X-Priority", "1");
			message.setFrom(new InternetAddress(from));
			InternetAddress[] addressTo = new InternetAddress[to.length];
			LocalDate dat = java.time.LocalDate.now();   
			for (int i = 0; i < to.length; i++)
				addressTo[i] = new InternetAddress(to[i]);
			message.setRecipients(Message.RecipientType.TO, addressTo);
			message.setSubject(subject + " "+ "[" + dat + "]");

			StringBuilder msg = new StringBuilder(); // creating mail body
			msg.append("Hi Team," + "\n");
			msg.append("\n");
			msg.append("Please find the Summary Report");
			msg.append("\n\n");
			msg.append("Thanks & Regards,\n");
			msg.append("GTO-INDIA-QA-TEAM");

			BodyPart body = new MimeBodyPart();

			body.setText(msg.toString());
			// body.setContent(messageBody,"text/html");

			BodyPart attachment = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentPath);
			attachment.setDataHandler(new DataHandler(source));
			attachment.setFileName(attachmentName);
			BodyPart attachment1 = new MimeBodyPart();
			DataSource source1 = new FileDataSource(attachmentPath1);
			attachment1.setDataHandler(new DataHandler(source1));
			attachment1.setFileName(attachmentName1);
			BodyPart attachment2 = new MimeBodyPart();
			DataSource source2 = new FileDataSource(attachmentPath2);
			attachment2.setDataHandler(new DataHandler(source2));
			attachment2.setFileName(attachmentName2);
			// To get .html files from reports folder
			File selectFolder = new File("reports");
			File[] listOfFiles = selectFolder.listFiles();
			String attachmentName3 = "";
			String attachmentfileName = "";
			for(File file : listOfFiles){
			if(file.getName().contains(".html")){
				attachmentName3 = file.getAbsolutePath();
				attachmentfileName= file.getName();
			}
			}
			BodyPart attachment3 = new MimeBodyPart();
			DataSource source3 = new FileDataSource(attachmentName3);
			attachment3.setDataHandler(new DataHandler(source3));
			attachment3.setFileName(attachmentfileName);
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(body);
			multipart.addBodyPart(attachment);
			multipart.addBodyPart(attachment1);
			multipart.addBodyPart(attachment2);
			multipart.addBodyPart(attachment3);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Sucessfully Sent mail to All Users");
			bus.close();

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	private static class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			String username = TestConfig.from;
			String password = TestConfig.password;
			return new PasswordAuthentication(username, password);
		}
	}

}
