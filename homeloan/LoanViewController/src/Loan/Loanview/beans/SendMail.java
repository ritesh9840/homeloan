package Loan.Loanview.beans;

import com.sun.mail.smtp.SMTPTransport;

import java.net.InetAddress;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SendMail {
    public SendMail() {
        super();
    } 
    
    public static  void main(String argv[]) {
        try {
            sendMail("riteshrajputg@gmail.com", "riteshrajput@hotmail.com", "test", "Loan Test");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
    
    
    
    @SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
    public static  void sendMail(String from,String to,String subject,String text) throws NamingException {
        
        InitialContext ic = new InitialContext();
              Session session = (Session) ic.lookup("mail/NewMailSession");
        

              Properties props = session.getProperties();
              System.out.println("Laon Mail: PROPERTIES LIST: ");
           
           // uncomment the below line to display mail properties defined in weblogic server server
             // props.list(System.out);

             
              if(to==null || to.equals(""))
                  to = "riteshrajput@hotmail.com";
              
              if(subject==null || subject.equals(""))
                  subject = "Loan Approval Conformation Message";

              String mailhost = props.getProperty("mail.smtp.host");
              System.out.println("Loan:: mailhost = " + mailhost);
              String user = props.getProperty("mail.smtp.user");
              System.out.println("Loan:: user = " + user);
              String password = props.getProperty("mail.smtp.password");
              System.out.println("Loan:: password = " + password);
              String protocol = props.getProperty("mail.transport.protocol");
              System.out.println("Loan:: protocol = " + protocol);
              
              String authorization = props.getProperty("mail.smtp.auth");
              String mailDisabled = props.getProperty("mail.disable");
              String verboseProp = props.getProperty("mail.verbose");
              String debugProp = props.getProperty("mail.debug");
              
              boolean sentDisabled = false;
              if(mailDisabled.equals("true"))
                  sentDisabled = true;
              
              if(!sentDisabled){
                  
                  boolean auth = false;
                  if(authorization.equals("true"))
                      auth = true;
                  
                  boolean verbose = false;
                  if(verboseProp.equals("true"))
                      verbose = true;
          
                  String mailer = "smtpsend";
                  
                  if(debugProp.equals("true"))
                      session.setDebug(true);
                  else
                      session.setDebug(false);
          
                  System.out.println("Laon: session initialized.");
                        
                  Message msg = new MimeMessage(session);

            try {
                msg.setFrom(new InternetAddress(user));
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            try {
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            System.out.println("LKAPOOR: recipient set.");

            try {
                msg.setSubject(subject);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            try {
                msg.setText(text);
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            try {
                msg.setHeader("X-Mailer", mailer);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            try {
                msg.setSentDate(new Date());
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            System.out.println("Loan: Metadata set.");
          
                  SMTPTransport t=null;
            try {
                t = (SMTPTransport) session.getTransport(protocol);
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            }

            System.out.println("Laon: Gettting Transport.");
          
                  try {
                      System.out.println("Laon: Before connect via authorization.");
                      t.connect(mailhost, user, password);
                      t.sendMessage(msg, msg.getAllRecipients());
                      System.out.println("Loan: message sent.");
                  } catch (MessagingException e) {
                e.printStackTrace();
            } finally {
                          if (verbose)
                              System.out.println("Response: " + t.getLastServerResponse());
                try {
                    t.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
                  
                  System.out.println("\nMail was sent successfully.");
              }else{
                  System.out.println("Mail Sending is disabled.");
              }
        
        
    }
    
    
    
}
