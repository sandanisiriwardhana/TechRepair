package utilities;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * Email utility class to send emails.
 */
public class Mail {
    // Session and MimeMessage are class-level variables
    Session newSession = null;
    MimeMessage mimeMessage = null;

    /*public static void main(String[] args) {
        try {
            Mail mail = new Mail();
            mail.setupServerProperties();
            mail.draftEmail();
            mail.sendEmail();
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println("Invalid email address format.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error in sending email.");
        }
    }*/

    public void sendEmail() throws MessagingException {
        String fromUser = "sliituob@gmail.com"; 
        String fromUserPassword = "umdf djth jyvt wlns "; 
        String emailHost = "smtp.gmail.com";

        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent");
    }

    public MimeMessage draftEmail() throws AddressException, MessagingException {
        String[] emailRecipients = {"techrepair110@gmail.com", "sandanimadushika.7@gmail.com"};
        String emailSubject = "Test Mail";
        String emailBody = "Test Body of my email";
        mimeMessage = new MimeMessage(newSession);

        for (String recipient : emailRecipients) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        }
        mimeMessage.setSubject(emailSubject);

        // Create message body part
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "text/html");

        // Create multipart
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);

        // Set the content of the message
        mimeMessage.setContent(multipart);

        return mimeMessage;
    }

    public void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587"); // Correct port for TLS/STARTTLS
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
        properties.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host

        // Create the email session
        newSession = Session.getInstance(properties, null);
    }
}
