package com.sda;

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
        Service service1 = choosedServices.stream().filter(a -> a.getServiceName().equals(service.getServiceName()))
                .findFirst().orElse(null);
        if (service1 == null) {
            this.choosedServices.add(service);
        }
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
