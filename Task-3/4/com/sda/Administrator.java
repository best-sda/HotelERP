package com.sda;

import java.util.ArrayList;
import java.util.List;

public class Administrator {

    private static Administrator instance;
    private Administrator(){}

    List<Room> roomList = new ArrayList <Room>();
    List<Guest> guestList = new ArrayList <Guest>();
    List<Service> serviceList = new ArrayList <>();

    public static Administrator getInstance(){
        if(instance == null){
            instance = new Administrator();
        }
        return instance;
    }

    public void setRegistration(int guestIDcard, int roomNumber){

        Guest guest = guestList.stream().filter(a -> a.idCardNumber == guestIDcard ).findFirst().orElse(null);
        Room room = roomList.stream().filter(a -> a.number == roomNumber).findFirst().orElse(null);
        if (guest.getRoom() == null) { guest.setRoom(room.number); }

    }

    public void setRoomStatus(Room room){

    }

    public void setService (String name, String description) {
        serviceList.add(new Service(name, description));

    }

    public void closeService (String name){
        serviceList.remove(serviceList.stream()
                .filter(a -> a.ServiceName.equals(name)).findFirst().orElse(null));
    }

}
