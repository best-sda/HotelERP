package com.sda;

import java.util.ArrayList;
import java.util.List;

public class Guest extends Person {

    Integer room;
    List<Service> choosedServices = new ArrayList <>();

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
       this.room = room;
    }
}
