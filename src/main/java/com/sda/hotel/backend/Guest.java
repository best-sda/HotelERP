/*
 * Created by Dmitry Scherbakov in 02.12.2019, 16:11
 */

package com.sda.hotel.backend;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Guest extends Person implements Serializable {

    private Integer room;
    private List <Service> choosedServices = new ArrayList <>();

    public Guest(String name, String surName, int id) {
        super(name, surName, id);
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public void setChooseServices(Service service) {
        choosedServices.stream().filter(a -> a.getServiceName().equals(service.getServiceName()))
                .findFirst().ifPresent(s -> this.choosedServices.add(service));

    }

    public void getChooseServices() {
        for (Service service : choosedServices) {
            System.out.println(" ---" + service.getServiceName());
        }

    }

    public int getCountServices() {
        return choosedServices.size();
    }

}

