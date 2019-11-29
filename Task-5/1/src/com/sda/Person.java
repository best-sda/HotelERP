package com.sda;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private String surname;
    private int idCardNumber;

    public Person(String name, String surname, int idCardNumber) {
        this.name = name;
        this.surname = surname;
        this.idCardNumber = idCardNumber;
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
