/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:13
 */

package com.sda.hotel.backend.domain;

import java.io.Serializable;

public class Room implements Serializable {
    private Integer number;
    private String status;
    private Boolean repair;
    private Boolean busy;
    private int cost;

    public Room(Integer number, String status,
                Boolean repair, Boolean busy, int cost) {
        this.number = number;
        this.status = status;
        this.repair = repair;
        this.busy = busy;
        this.cost = cost;
    }

    public Room(Integer number, String status, int cost) {
        this.number = number;
        this.status = status;
        this.repair = false;
        this.busy = false;
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getRepair() {
        return repair;
    }

    public void setRepair(Boolean repair) {
        this.repair = repair;
    }

    public Integer getNumber() {
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
