package com.attra.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository("EmailSendingInterface")
@Service
public class EmailUtil implements EmailSendingInterface{
               
                public static String sendMailWithoutAttachment(String to, String subject, String body, String replyTo) throws AddressException, MessagingException {
                   
                    final String username = "gayathry.ashwin@attra.com.au";
                    final String password = "Ashw@1986";
                   
                    String replyToAddress = replyTo;
                   
                    String from = "no-reply@attra.com.au";
                   
                    try {
                    String host = "192.168.12.70";
                    Properties props=System.getProperties();
                   
                    props.setProperty("mail.smtp.auth", "true");
                                props.setProperty("mail.smtp.starttls.enable", "true");
                                props.setProperty("mail.smtp.host", "192.168.12.70"); 
                                props.setProperty("mail.smtp.port", "25");
                                props.setProperty("mail.smtp.ssl.trust", "smtp.office365.com");
                                props.setProperty("mail.transport.protocol", "smtp");
                                props.setProperty("mail.user", username);
                                props.setProperty("mail.password", password);
                               
                                Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                                                protected PasswordAuthentication getPasswordAuthentication() {
                                                                return new PasswordAuthentication(username, password);
                                                                //System.out.println("session"+username);
                                                }
                                });
       
                                MimeMessage message = new MimeMessage(session);
                                message.setFrom(new InternetAddress(from));
                                Address toAddress = new InternetAddress(to);
                                message.setRecipient(Message.RecipientType.TO, toAddress);
                               
                                message.setReplyTo(new javax.mail.Address[]
                                                                {
                                                                    new javax.mail.internet.InternetAddress(replyToAddress)
                                                                });
                               
                                message.setSubject(subject);
                                message.setText(body);
                                Transport transport = session.getTransport("smtp");
                                transport.connect(host, username, password);
                                message.saveChanges();
                                Transport.send(message);
                                System.out.println(message);
                                transport.close();
                } catch (Exception e) {
                                System.out.println("<html><head></head><body>");
                                System.out.println("ERROR: " + e);
                                System.out.println("</body></html>");
                               
                                return "msg not sent";
                }
                return "msg sent";
 
}
 
 @Autowired
	SessionFactory factory;
 @Transactional
  public void sendEmail(int appId,String updatedStatus) throws AddressException, MessagingException
  {
	  String name=null;
	  String email=null;
	  String status="pending";
	  String doctorNm=null;
	  String bookingDate=null;
	  String timeSlotGot=null;
	  Query query=null;
	 org.hibernate.Session session=factory.getCurrentSession();
	  query=session.createQuery("select a.patientName from Appointmentdetail a where a.appointmentId=:appId and a.status=:status");
		query.setParameter("appId", appId);
		query.setParameter("status", status);
		List list=query.list();
		if(list!=null) {
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			name=(String) it.next();
			System.out.println(name);
		}}
		if(name!=null) {
			query=session.createQuery("select u.email from Userregistration u where u.patientName=:name");
			query.setParameter("name", name);
		
		List seclist=query.list();
		Iterator secit=seclist.iterator();
		while(secit.hasNext())
		{
			email=(String) secit.next();
		}
		 query=session.createQuery("select a.doctorName from Appointmentdetail a where a.appointmentId=:appId and a.status=:status");
		query.setParameter("appId", appId);
		query.setParameter("status", status);
		List list1=query.list();
		if(list1!=null) {
		Iterator it=list1.iterator();
		while(it.hasNext())
		{
			doctorNm=(String) it.next();
			
		}}
		 query=session.createQuery("select a.appointmentDate from Appointmentdetail a where a.appointmentId=:appId and a.status=:status");
		 query.setParameter("appId", appId);
		 query.setParameter("status", status);
		List list2=query.list();
		if(list2!=null) {
		Iterator it=list2.iterator();
		while(it.hasNext())
		{
			bookingDate=(String) it.next();
			
		}}
		query=session.createQuery("select a.timeSlot from Appointmentdetail a where a.appointmentId=:appId and a.status=:status");
		query.setParameter("appId", appId);
		query.setParameter("status", status);
		List list3=query.list();
		if(list3!=null) {
		Iterator it=list3.iterator();
		while(it.hasNext())
		{
			timeSlotGot=(String) it.next();
			
		}}
		}
		if(email!=null) {
                  String newline = System.getProperty("line.separator");
                 // String emailID = "sunil.kumar3@attra.com.au";
                  String str2 = email.substring(0, email.indexOf("."));
                  String username = str2.substring(0, 1).toUpperCase() + str2.substring(1).toLowerCase();
                 
                  String body = "Dear "+name+","+newline+newline+"This is auto  Generated  email from AttraHealthcare."
                                                +newline+"Your appointment has "+updatedStatus+" for "+bookingDate+" at "+timeSlotGot+"  with "+doctorNm+","
                                                +newline+newline+"Registered Id  : " +email
                                               /* +newline+"Pin Id "+""+newline+newline+"Regards,"+newline+"Attraction Team"*/;
                 
                  String msg = EmailUtil.sendMailWithoutAttachment(email, "Check ", body , "sunil.kumar3@attra.com.au");
                  System.out.println("msg--");
                 
  }
  }
 /*@Autowired
	SessionFactory secfactory;
@Transactional
public void sendEmailIfCancel(int appId) throws AddressException, MessagingException
{
	  String name=null;
	  String email=null;
	  String status="pending";
	 org.hibernate.Session session=secfactory.getCurrentSession();
	 Query query=session.createQuery("select a.patientName from Appointmentdetail a where a.appointmentId=:appId and a.status=:status or a.status");
		query.setParameter("appId", appId);
		query.setParameter("status", status);
		List list=query.list();
		if(list!=null) {
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			name=(String) it.next();
			System.out.println(name);
		}}
		if(name!=null) {
		Query secquery=session.createQuery("select u.email from Userregistration u where u.patientName=:name");
		secquery.setParameter("name", name);
		
		List seclist=secquery.list();
		Iterator secit=seclist.iterator();
		while(secit.hasNext())
		{
			email=(String) secit.next();
		}
		}
		if(email!=null) {
               String newline = System.getProperty("line.separator");
              // String emailID = "sunil.kumar3@attra.com.au";
               String str2 = email.substring(0, email.indexOf("."));
               String username = str2.substring(0, 1).toUpperCase() + str2.substring(1).toLowerCase();
              
               String body = "Hi "+username+","+newline+newline+"This is Gayathry  Generated  email from Gayathry Team  Mobile."
                                             +newline+"Use Sample mail ."
                                             +newline+newline+"Registered Id  : " +email
                                             +newline+"Pin Id "+""+newline+newline+"Regards,"+newline+"Attraction Team";
              
               String msg = EmailUtil.sendMailWithoutAttachment(email, "Check ", body , "sunil.kumar3@attra.com.au");
               System.out.println("msg--");
              
}
}*/
}
  