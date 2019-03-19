package com.attra.Utils;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailSendingInterface {
public void sendEmail(int appId,String updatedStatus) throws AddressException, MessagingException;
/*public void sendEmailIfCancel(int appId) throws AddressException, MessagingException;*/
}
