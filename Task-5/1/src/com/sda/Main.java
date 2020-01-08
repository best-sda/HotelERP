package com.sda;

public class Main {

    public static void main(String[] args) {
        Administrator administrator = Administrator.getInstance();
        Utils.load();
        System.out.println("Всего комнат: " + administrator.getRoomList().size() + " Из них свободных: " + administrator.freeRoomCount());
        administrator.printRoomList();
        administrator.printGuestList();

    }

}
