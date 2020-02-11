/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:26
 */

package com.sda.hotel.backend.domain;

public class Order {
    private Integer id;
    private String dateArival;
    private String dateDepart;
    private Boolean paid;
    private Integer roomId;
    private  Integer guestId;
    private Integer serviceId;

    public Order(Integer id, String dateArival, String dateDepart, Boolean paid, Integer roomId, Integer guestId, Integer serviceId) {
        this.id = id;
        this.dateArival = dateArival;
        this.dateDepart = dateDepart;
        this.paid = paid;
        this.roomId = roomId;
        this.guestId = guestId;
        this.serviceId = serviceId;
    }
    public Order() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateArival() {
        return dateArival;
    }

    public void setDateArival(String dateArival) {
        this.dateArival = dateArival;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
