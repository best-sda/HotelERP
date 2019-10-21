package com.sda;

public class Plane {
    private int planeID;
    private String name;
    private int countOfSeats;

    public Plane(int planeID, String name, int countOfSeats) {
        this.planeID = planeID;
        this.name = name;
        this.countOfSeats = countOfSeats;
    }


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
