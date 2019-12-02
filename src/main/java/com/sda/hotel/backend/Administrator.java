/*
 * Created by Dmitry Scherbakov in 02.12.2019, 16:09
 */

/*
 * Created by Dmitry Scherbakov in 02.12.2019, 16:09
 */

package com.sda.hotel.backend;

import com.sda.Guest;
import com.sda.Room;
import com.sda.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Administrator {

    private List <Room> roomList = new ArrayList <Room>();
    private List <Guest> guestList = new ArrayList <Guest>();
    private List <Service> serviceList = new ArrayList <>();
    private static Administrator instance;

    private Administrator() {
    }

    public static Administrator getInstance() {
        if (instance == null) {
            instance = new Administrator();
        }
        return instance;
    }

    private static void accept(Guest guest) {

    }

    public void addGuest(String name, String surName, int id) {
        Guest guest = new Guest(name, surName, id);
        guestList.add(guest);
    }

    public List <Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List <Room> roomList) {
        this.roomList = roomList;
    }

    public List <Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List <Guest> guestList) {
        this.guestList = guestList;
    }

    public void setServiceList(List <Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List <Service> getServiceList() {
        return serviceList;
    }

    public void setRegistration(int guestIDcard, int roomNumber) {
        guestList.stream().filter(a -> a.getIdCardNumber() == guestIDcard).findFirst().ifPresent(guest ->
                roomList.stream().filter(a -> a.getNumber() == roomNumber).findFirst().ifPresent(room -> {
                    room.setBusy(true);
                    guest.setRoom(room.getNumber());
                }));
    }

    public void setServiceToGuest(int guestIdCard, String serviceName) {
        guestList.stream().filter(a -> a.getIdCardNumber() == guestIdCard).findFirst().ifPresent(g ->
                serviceList.stream().filter(a -> a.getServiceName().equals(serviceName)).findFirst()
                        .ifPresent(g::setChooseServices));
    }

    public void cancelRegistration(int guestIdCard) {
        guestList.stream().filter(a -> a.getIdCardNumber() == guestIdCard).findFirst().ifPresent(guest ->
                roomList.stream().filter(a -> a.getNumber() == guest.getRoom()).findFirst().ifPresent(room -> {
                    room.setBusy(false);
                    guest.setRoom(null);
                }));
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
        serviceList.remove(serviceList.stream().filter(Objects::nonNull)
                .filter(a -> a.getServiceName().equals(name)).findFirst().get());
    }

    public void changeCost(int roomNumber, int newCost) {
        roomList.stream()
                .filter(a -> a.getNumber() == roomNumber).findFirst().ifPresent(r -> r.setCost(newCost));
    }

    public void changeCost(String serviceName, int newCost) {
        serviceList.stream().filter(a -> a.getServiceName().equals(serviceName))
                .findFirst().ifPresent(s -> s.setCost(newCost));

    }

    public void printRoomList() {
        System.out.println("Rooms:");
        roomList.forEach(r -> Optional.ofNullable(r)
                .ifPresent(room -> System.out.println("Room #" + room.getNumber() + " is "
                        + (room.getBusy() ? " ready" : " busy"))));

    }

    public void printGuestList() {
        System.out.println("Guests:");
        guestList.forEach(g -> Optional.ofNullable(g).ifPresent(guest -> {
            System.out.println(guest.getName()
                    + " " + guest.getSurname()
                    + (guest.getRoom() == null ? " not registred" : " in room " + guest.getRoom())
                    + " choose services: " + guest.getCountServices());
            g.getChooseServices();

        }));
    }

    // Task5-1 посчитать количество заселенных/свободных комнат
    public long busyRoomCount() {
        return roomList.stream().filter(Room::getBusy).count();
    }

    public long freeRoomCount() {
        return roomList.stream().filter(room -> !room.getBusy() && !room.getRepair()).count();
    }

}
