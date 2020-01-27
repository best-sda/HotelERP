/*
 * Created by Dmitry Scherbakov in 20.01.2020, 14:48
 */

package com.sda.hotel.backend.controller;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.service.RoomService;
import com.sda.hotel.backend.utils.EmailAutentificator;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;
@Component
public class EmailController extends Thread {
    int TIME = 6000;
    @Autowired
    GuestService guestServiceImpl;
    @Autowired
    RoomService  roomServiceImpl;

    public int getTIME() {
        return TIME;
    }

    public void setTIME(int TIME) {
        this.TIME = TIME;
    }

    public GuestService getGuestServiceImpl() {
        return guestServiceImpl;
    }

    public void setGuestServiceImpl(GuestService guestServiceImpl) {
        this.guestServiceImpl = guestServiceImpl;
    }

    public RoomService getRoomServiceImpl() {
        return roomServiceImpl;
    }

    public void setRoomServiceImpl(RoomService roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
    }

    @Override

    public void run() {
        synchronized (this) {
            try {
                while (!Thread.interrupted()) {

                    Thread.currentThread().setName("emailController");
                   try{
                       this.wait(TIME);
                   } catch (InterruptedException e) {
                   }

                    this.sendMail();
                    System.out.println("send");

                }
            }catch( IOException | MessagingException e){
                    e.printStackTrace();
             }


        }
    }

    private void sendMail() throws IOException, MessagingException {
        InputStream is = new FileInputStream("C:\\Users\\best-\\IdeaProjects\\newHome\\src\\main\\resources\\email.properties");
        Reader reader = new InputStreamReader(is, "UTF-8");
        Properties pr = new Properties();
        pr.load(reader);
        Authenticator auth = new EmailAutentificator(pr.getProperty("user"), pr.getProperty("pass"));
        Session session = Session.getDefaultInstance(pr, auth);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(pr.getProperty("from")));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(pr.getProperty("to")));
        String statistic = getStatistics();
        msg.setSubject("Statistics");
        msg.setText(statistic);
        Transport.send(msg);
    }

    private String getStatistics() {
      return "Chekined gests = " + guestServiceImpl.getChekinedGests().size()
        +"Rooms = " + roomServiceImpl.roomList().size();
    }

}
