

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
public class Email {
	
	Processor processor=new Processor();
	LinkedList<String> emails = new LinkedList();
	
	public boolean Send(String test,String destination) {
		
  String host = "smtp.gmail.com";
  int port = 587;
  final String username = "tommygaming1997@gmail.com";
  final String password = "tommy86107";
  
  Properties props = new Properties();
  props.put("mail.smtp.host", host);
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.port", port);
  Session session = Session.getInstance(props, new Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
   }
  });

  try {

   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress(username));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destination));
   message.setSubject("系辦通知");
   message.setText(test);

   Transport transport = session.getTransport("smtp");
   transport.connect(host, port, username, password);

   Transport.send(message);

   
   return true;
  } catch (MessagingException e) {
   throw new RuntimeException(e);
  }
	}
	
}