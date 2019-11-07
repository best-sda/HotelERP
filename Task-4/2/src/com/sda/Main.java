package com.sda;

public class Main {

    public static void main(String[] args) {
        Administrator administrator = Administrator.getInstance();
        Utils.load();
        administrator.printRoomList();
        administrator.printGuestList();
    }

}
