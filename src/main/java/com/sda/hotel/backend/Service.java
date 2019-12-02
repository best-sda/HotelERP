/*
 * Created by Dmitry Scherbakov in 02.12.2019, 16:15
 */

package com.sda.hotel.backend;

import java.io.Serializable;

public class Service implements Serializable {

    private String serviceName;
    private int cost;
    private String description;

    public Service(String serviceName, int cost, String description) {
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

}
