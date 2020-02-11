/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:14
 */

package com.sda.hotel.backend.domain;

import java.io.Serializable;
import java.util.Random;

public class Service implements Serializable {

    private Integer Id;
    private String name;
    private Integer cost;
    private String description;

    public Service(String serviceName, int cost, String description) {
        this.Id = new Random().nextInt();
        this.name = serviceName;
        this.cost = cost;
        this.description = description;
    }
    public Service(){};

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}

