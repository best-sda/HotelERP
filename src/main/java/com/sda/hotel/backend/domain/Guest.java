/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:14
 */

package com.sda.hotel.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Guest extends Person implements Serializable {
    private Integer guestId;
    private Integer room;
    private List <Service> choosedServices = new ArrayList <>();

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public List <Service> getChoosedServices() {
        return choosedServices;
    }

    public void setChoosedServices(List <Service> choosedServices) {
        this.choosedServices = choosedServices;
    }

    public void addService (Service service) {
        choosedServices.add(service);
    }

    public Guest(String name, String surName, int idCard) {
        super(name, surName, idCard);
        this.guestId = new Random().nextInt();
    }
}
