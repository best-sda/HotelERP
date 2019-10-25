package com.sda;

public class Main {

    public static void main(String[] args) {
        Administrator administrator = new Administrator();
        administrator.addRoom(1, 1200);
        administrator.addRoom(2, 1800);
        administrator.addService("Breakfast", 150, "breakfast in the restaurant at 8:00-9:00");
        administrator.addGuest("Alex", "Shmit", 131244);
        administrator.addGuest("Nina", "Ivanova", 701612);
        administrator.setRegistration(131244, 2);
        administrator.setRegistration(701612, 1);
        administrator.setServiceToGuest(131244, "Breakfast");
        administrator.changeCost(2, 9999);
        administrator.changeCost("Breakfast", 200);
        administrator.cancelRegistration(131244);
        administrator.printRoomList();
        administrator.printGuestList();
    }

}
