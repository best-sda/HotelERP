package com.sda;

public class Room {

    private int number;
    private Boolean repair;
    private Boolean busy;
    private int cost;

    public Room(int number, Boolean repair, Boolean status, int cost) {
        this.number = number;
        this.repair = repair;
        this.busy = status;
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
