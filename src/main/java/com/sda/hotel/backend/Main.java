package com.sda;

public class Main {

    public static void main(String[] args) {
        Administrator administrator = Administrator.getInstance();
        Utils.load();
       // administrator.setRegistration(384092352, 235908);
        System.out.println("Всего комнат: " + administrator.getRoomList().size() + " Из них свободных: " + administrator.freeRoomCount());
        administrator.printRoomList();
        administrator.printGuestList();
        administrator.setRegistration(54734285, 92835435);

    }

}
