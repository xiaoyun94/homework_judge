import java.io.PrintStream;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail
{
  String host;
  String user;
  String password;
  String selfEmailAddr;
  
  public JavaMail(String user, String password, String host, String selfEmailAddr)
  {
    this.user = user;
    this.password = password;
    this.host = host;
    this.selfEmailAddr = selfEmailAddr;
  }
  
  public boolean send(String to, String subject, String content)
  {
    Properties props = new Properties();
    props.put("mail.smtp.host", this.host);
    props.put("mail.smtp.auth", "true");
    try
    {
      Session mailSession = Session.getDefaultInstance(props);
      Message message = new MimeMessage(mailSession);
      message.setFrom(new InternetAddress(this.selfEmailAddr));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject(subject);
      message.setText(content);
      message.saveChanges();
      
      Transport transport = mailSession.getTransport("smtp");
      
      transport.connect(this.host, this.user, this.password);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();
    }
    catch (AuthenticationFailedException exception)
    {
      exception.printStackTrace();
      return false;
    }
    catch (Exception e)
    {
      System.out.println(e);
      return false;
    }
    return true;
  }
}
