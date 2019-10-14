package com.sda;

public class Plane {
    int planeID;

    public Plane(int planeID, String name, int countOfSeats) {
        this.planeID = planeID;
        this.name = name;
        this.countOfSeats = countOfSeats;
    }

    String name;
    int countOfSeats;
    public int getPlaneID() {
        return planeID;
    }

    public void setPlaneID(int planeID) {
        this.planeID = planeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfSeats() {
        return countOfSeats;
    }

    public void setCountOfSeats(int countOfSeats) {
        this.countOfSeats = countOfSeats;
    }


}
