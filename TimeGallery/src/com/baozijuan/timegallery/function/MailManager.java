package com.baozijuan.timegallery.function;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.istack.internal.ByteArrayDataSource;

public class MailManager {

	private Properties properties;
	private Session session;
	private Message message;
	private Transport transport;

	private static MailManager mailManager = new MailManager();

	private MailManager() {
		properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp-mail.outlook.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		session = Session.getInstance(properties, null);
		session.setDebug(true);
	}

	public static MailManager getInstance() {
		return mailManager;
	}

	public void sendMail(String account) throws Exception {
		message = new MimeMessage(session);
		message.setFrom(new InternetAddress("baozijuan@outlook.com"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(account, false));
		message.setSubject("DO NOT REPLY");
		message.setDataHandler(new DataHandler(new ByteArrayDataSource(getMailContent(), "text/html")));
		message.setSentDate(new Date());

		transport = session.getTransport();
		transport.connect("smtp-mail.outlook.com", "baozijuan@outlook.com", "BaoZJ960606");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

	public byte[] getMailContent() {
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>\n");
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<title>Verification Code</title>\n");
		sb.append("<style>\n");
		sb.append("a{color: #0088cc; text-decoration: none;}\n");
		sb.append("a:hover{text-decoration: underline;}\n");
		sb.append("</style>\n");
		sb.append("</head>\n");
		sb.append(
				"<body style=\"font-family:Arial, Helvetica, sans-serif; font-size: 15px; line-height: 1.42857143; color: #333; background-color: #fff;\">\n");
		sb.append("<table width=\"800\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\n");
		sb.append("<tr><td style=\"width: 600px;\">\n");
		sb.append(
				"<p style=\"margin: .67em 0; font-size: 3em;\">Time Gallery<sub style=\"font-size: 0.5em; color: #696969;\">developed by Bao Cong</sub></p><hr>\n");
		sb.append("</td></tr>\n");
		sb.append("<tr><td style=\"text-align: center;\">\n");
		sb.append(
				"<p style=\"margin: .67em 0; font-size: 2em;\">Welcome to <a href=\"http://www.baozijuan.com\">baozijuan.com</a>!</p>\n");
		sb.append("</td></tr>\n");
		sb.append("<tr><td style=\"text-align: center;\">\n");
		sb.append("<p style=\"margin: .67em 0; font-size: 2em;\">Your Verification Code is <b>"
				+ VerifyCode.getVerifyCode() + "</b></p><hr>\n");
		sb.append("</td></tr>\n");
		sb.append("<tr><td>\n");
		sb.append("<p>This is an email sent by server automatically so do not reply it.</p>\n");
		sb.append(
				"<p>You're receiving this email because you recently created a new Time Gallery account or changed to a new email address or reset your password. If this wasn't you, please ignore this email. </p>\n");
		sb.append(
				"<p>Learn more about Time Gallery, please <a href=\"http://www.baozijuan.com/TimeGallery/about\">click here</a>.</p>\n");
		sb.append("<p><i>Copyright &copy; 2016 - 2017 Bao Cong. All rights reserved.</i></p>\n");
		sb.append("</td></tr>\n");
		sb.append("</table>\n");
		sb.append("</body>\n");
		sb.append("</html>\n");
		return sb.toString().getBytes();
	}

	public static class VerifyCode {

		private static final String STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		private static final int LENGTH = 6;
		private static final int WAIT = 600;
		private static long last = 0;
		private static String code = "";

		public static String getVerifyCode() {
			long interval = WAIT * 1000L;
			long now = new Date().getTime();
			if (now - last > interval) {
				last = now;
				Random random = new Random();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < LENGTH; i++) {
					int index = random.nextInt(STR.length());
					sb.append(STR.charAt(index));
				}
				code = sb.toString();
			}
			return code;
		}

	}
}
