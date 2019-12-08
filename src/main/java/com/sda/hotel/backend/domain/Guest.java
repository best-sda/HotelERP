/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:14
 */

package com.sda.hotel.backend.domain;

import com.sda.hotel.backend.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Guest extends Person {
    private Integer id;
    private Integer room;
    private List <Service> choosedServices = new ArrayList <>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Guest(String name, String surName, int idCard) {
        super(name, surName, idCard);
        this.id = new Random().nextInt();
    }
}
