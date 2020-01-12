/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:14
 */

package com.sda.hotel.backend.domain;

import java.io.Serializable;
import java.util.Random;

public class Person implements Serializable {
    private Integer personId;
    private String name;
    private String surname;
    private int idCardNumber;

    public Person(String name, String surname, int idCardNumber) {
        this.name = name;
        this.surname = surname;
        this.idCardNumber = idCardNumber;
        this.personId = new Random().nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(int idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

}
