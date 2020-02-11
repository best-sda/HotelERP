/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:13
 */

package com.sda.hotel.backend.domain;

import java.io.Serializable;

public class Room implements Serializable {
    private Integer id;
    private Integer roomNumber;
    private String status;
    private Boolean busy;
    private int cost;

    public Room(Integer id, Integer roomNumber, String status, Boolean busy, int cost) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.status = status;
        this.busy = busy;
        this.cost = cost;
    }
    public Room() {};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
