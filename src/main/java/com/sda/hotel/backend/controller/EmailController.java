/*
 * Created by Dmitry Scherbakov in 20.01.2020, 14:48
 */
package com.sda.hotel.backend.controller;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.service.RoomService;
import com.sda.hotel.backend.utils.EmailAutentificator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

@Component
public class EmailController extends Thread {
    private static int TIME = 6000;
    @Autowired
    private GuestService guestServiceImpl;
    @Autowired
    private RoomService roomServiceImpl;

    public int getTIME() {
        return TIME;
    }

    public void setTIME(int TIME) {
        EmailController.TIME = TIME;
    }

    public GuestService getGuestServiceImpl() {
        return guestServiceImpl;
    }

    public void setGuestServiceImpl(final GuestService guestServiceImpl) {
        this.guestServiceImpl = guestServiceImpl;
    }

    public RoomService getRoomServiceImpl() {
        return roomServiceImpl;
    }

    public void setRoomServiceImpl(final RoomService roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
    }

    private Logger logger = LogManager.getLogger(EmailController.class);

    @Override
    public void run() {
        synchronized (this) {
            try {
                while (!Thread.interrupted()) {
                    Thread.currentThread().setName("emailController");
                    try {
                        this.wait(TIME);
                    } catch (InterruptedException e) {
                        logger.info("thread wait");
                    }

                    this.sendMail();
                    System.out.println("send");
                }
            } catch (IOException | MessagingException e) {
                logger.error("Send email failed" + e.getMessage());
            }


        }
    }

    private void sendMail() throws IOException, MessagingException {
        InputStream is = new FileInputStream(
                "C:\\Users\\best-\\IdeaProjects\\newHome"
                        + "\\src\\main\\resources\\email.properties");
        Reader reader = new InputStreamReader(is);
        Properties pr = new Properties();
        pr.load(reader);
        Authenticator auth = new EmailAutentificator(pr.getProperty("user"),
                pr.getProperty("pass"));
        Session session = Session.getDefaultInstance(pr, auth);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(pr.getProperty("from")));
        msg.setRecipient(Message.RecipientType.TO,
                new InternetAddress(pr.getProperty("to")));
        String statistic = getStatistics();
        msg.setSubject("Statistics");
        msg.setText(statistic);
        Transport.send(msg);
    }

    private String getStatistics() {
        return "Chekined gests = " + guestServiceImpl.getChekinedGests().size()
                + "Rooms = " + roomServiceImpl.roomList().size();
    }

}
