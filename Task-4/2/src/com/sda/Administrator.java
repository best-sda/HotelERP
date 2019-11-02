package com.sda;

import java.util.ArrayList;
import java.util.List;

public class Administrator  {

    List <Room> roomList = new ArrayList <Room>();
    List <Guest> guestList = new ArrayList <Guest>();
    List <Service> serviceList = new ArrayList <>();
    private static Administrator instance;
    private Administrator(){}
    public static Administrator getInstance(){
        if(instance == null){
            instance = new Administrator();
        }
        return instance;
    }

    public void addGuest(String name, String surName, int id) {
        Guest guest = new Guest(name, surName, id);
        guestList.add(guest);
    }


    public void setRegistration(int guestIDcard, int roomNumber) {
        Guest guest = guestList.stream()
                .filter(a -> a.getIdCardNumber() == guestIDcard).findFirst().orElse(null);
        Room room = roomList.stream().filter(a -> a.getNumber() == roomNumber).findFirst().orElse(null);
        if (guest.getRoom() == null && room.getBusy() == false) {
            room.setBusy(true);
            guest.setRoom(room.getNumber());
        }
    }

    public void setServiceToGuest(int guestIdCard, String serviceName) {
        Guest guest = guestList.stream()
                .filter(a -> a.getIdCardNumber() == guestIdCard).findFirst().orElse(null);
        Service service = serviceList.stream()
                .filter(a -> a.getServiceName().equals(serviceName)).findFirst().orElse(null);
        guest.setChooseServices(service);
    }

    public void cancelRegistration(int guestIdCard) {
        Guest guest = guestList.stream()
                .filter(a -> a.getIdCardNumber() == guestIdCard).findFirst().orElse(null);
        if (guest.getRoom() != null) {
            Room room = roomList.stream().filter(a -> a.getNumber() == guest.getRoom()).findFirst().orElse(null);
            room.setBusy(false);
            guest.setRoom(null);
        }
    }

    public Service addService(String name, int cost, String description) {
        Service service = new Service(name, cost, description);
        serviceList.add(service);
        return service;
    }

    public Room addRoom(int number, int cost) {
        Room room = new Room(number, false, false, cost);
        roomList.add(room);
        return room;
    }

    public void closeService(String name) {
        serviceList.remove(serviceList.stream()
                .filter(a -> a.getServiceName().equals(name)).findFirst().orElse(null));
    }

    public void changeCost(int roomNumber, int newCost) {
        Room room = roomList.stream().filter(a -> a.getNumber() == roomNumber).findFirst().orElse(null);
        room.setCost(newCost);
    }

    public void changeCost(String serviceName, int newCost) {
        Service service = serviceList.stream().filter(a -> a.getServiceName().equals(serviceName))
                .findFirst().orElse(null);
        service.setCost(newCost);
    }

    public void printRoomList() {
        System.out.println("Rooms:");
        for (Room room : roomList) {
            System.out.println("Room #" + room.getNumber() + " is " + (room.getBusy() ? " ready" : " busy"));
        }
    }

    public void printGuestList() {
        System.out.println("Guests:");
        for (Guest guest : guestList) {
            System.out.println(guest.getName() + " " + guest.getSurname() +
                    (guest.getRoom() == null ? " not registred" : " in room " + guest.getRoom()) + " choose services: " + guest.getCountServices());
            guest.getChooseServices();
            ;
        }
    }

    public List <Service> getServiceList() {
        return serviceList;
    }

}
