package com.sda;

public class Person {
    public Person(String fullName, int IDCardNumber, int dateOfBirth, String sex) {
        this.fullName = fullName;
        this.IDCardNumber = IDCardNumber;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    String fullName;
    int IDCardNumber;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getIDCardNumber() {
        return IDCardNumber;
    }

    public void setIDCardNumber(int IDCardNumber) {
        this.IDCardNumber = IDCardNumber;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    int dateOfBirth;
    String sex;
}
