package com.sda;

public class Main {

    public static void main(String[] args) {
        Administrator administrator = Administrator.getInstance();
        SaveAndLoad.load();
        administrator.printRoomList();
        administrator.printGuestList();
    }

}
