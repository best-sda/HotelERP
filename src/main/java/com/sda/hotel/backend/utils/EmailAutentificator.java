/*
 * Created by Dmitry Scherbakov in 20.01.2020, 15:53
 */

package com.sda.hotel.backend.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailAutentificator extends Authenticator {
    private String user;
    private String password;

    public EmailAutentificator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        String user = this.user;
        String password = this.password;
        return new PasswordAuthentication(user, password);
    }
}
