/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:14
 */

package com.sda.hotel.backend.domain;

import java.io.Serializable;
import java.util.Random;

public class Guest implements Serializable {
    private Integer id;
    private String lastName;
    private String firstName;
    private int certNumber;
    private String phoneNumber;
    private Random random = new Random();

    public Guest(String lastName, String firstName, int certNumber, String phoneNumber) {
        this.id = random.nextInt();
        this.lastName = lastName;
        this.firstName = firstName;
        this.certNumber = certNumber;
        this.phoneNumber = phoneNumber;
    }

    public Guest() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(int certNumber) {
        this.certNumber = certNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
