/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:14
 */

package com.sda.hotel.backend.domain;

import java.io.Serializable;
import java.util.Random;

public class Service implements Serializable {

    private Integer id;
    private String serviceName;
    private Integer cost;
    private String description;

    public Service(String serviceName, int cost, String description) {
        this.id = new Random().nextInt();
        this.serviceName = serviceName;
        this.cost = cost;
        this.description = description;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}

